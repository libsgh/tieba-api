package com.github.libsgh.tieba.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * httpclient请求工具类
 * @author libs
 * 2018-4-8
 */
public class HttpKit {
	
	private Logger logger =LogManager.getLogger(getClass());
	
    private volatile static HttpKit bc;
    
	private CookieStore cookieStore = new BasicCookieStore();
	
	private static String Content_Type = "application/x-www-form-urlencoded";
	private static String User_Agent = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.116 Safari/537.36";
	private HttpKit(){}
	
	public static HttpKit getInstance(){
		if(bc == null){
		    synchronized (HttpKit.class) {  
                if (bc == null) {  
                    bc = new HttpKit();  
                }  
		    }  
		}
		return bc;
	}
	
	public HttpResponse execute(String url) throws Exception{
		return execute(url, null, null, null);
	}
	public HttpResponse execute(String url, String cookie) throws Exception{
		return execute(url, cookie, null, null);
	}
	public HttpResponse execute(String url, String cookie, List<NameValuePair> params) throws Exception{
		return execute(url, cookie, params, null);
	}
	/**
	 * @param url url
	 * @param cookie cookie
	 * @param headerMaps headerMaps
	 * @return HttpResponse
	 * @throws Exception
	 * 带header参数的请求
	 */
	public HttpResponse execute(String url, String cookie, HashMap<String, Header> headerMaps) throws Exception{
		return execute(url, cookie, null, headerMaps);
	}
	
	/**
	 * 百度post/get请求
	 * @param url url
	 * @param cookie bduss、stoken
	 * @param params params
	 * @param headerMaps 添加额外header
	 * @return HttpResponse
	 * 20170117添加stoken
	 * @throws Exception 网络请求异常
	 */
	public HttpResponse execute(String url, String cookie, List<NameValuePair> params, HashMap<String, Header> headerMaps) throws Exception{
		RequestConfig config = RequestConfig.custom().setRedirectsEnabled(false).build();
		HttpResponse response = null;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpUriRequest request = null;
		try {
			if (params != null) {
				HttpPost httpPost = new HttpPost(url);
				HttpEntity postBodyEnt = new UrlEncodedFormEntity(params, "utf-8");
				httpPost.setEntity(postBodyEnt);
				request = httpPost;
			} else {
				HttpGet httpGet = new HttpGet(url);
				httpGet.setConfig(config);
				request = httpGet;
			}
			if(headerMaps != null){
				request.setHeaders(this.build(headerMaps));
			}
			request.setHeader("Content-Type", Content_Type);
			request.setHeader("User-Agent", User_Agent);
			HttpContext localContext = new BasicHttpContext();
			if(!StrKit.isBlank(cookie)){
				//通过header手动设置cookie
				request.setHeader("Cookie",cookie);
			}else {
				localContext.setAttribute(HttpClientContext.COOKIE_STORE, cookieStore);
			}
			response = httpClient.execute(request, localContext);
			logger.debug("[HTTP状态码:" + response.getStatusLine().getStatusCode() + "]" + "-->Request URL:" + url);
			int statusCode = response.getStatusLine().getStatusCode();
			if(statusCode == HttpStatus.SC_OK){//200
				return  response;
			} else if(statusCode == HttpStatus.SC_MOVED_TEMPORARILY){//302重定向
				Header h = response.getFirstHeader("Location");
	            if(h != null){
	                HttpGet reHttpGet = new HttpGet(h.getValue());
	                reHttpGet.setHeader("Cookie", cookie);
	                reHttpGet.setConfig(config);
	        		response = httpClient.execute(reHttpGet);
	        		return response;
	            }
			}
		} catch (Exception e) {
			logger.error("http请求异常", e);
		}
		return null;
	}
	
	/**
	 * 获取stoken
	 * @param authUrl authUrl
	 * @param cookie cookie
	 * @return stoken
	 */
    public String doGetStoken(String authUrl,String cookie) {
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	HttpGet httpGet = new HttpGet(authUrl);
    	CloseableHttpResponse response = null;
    	String httpStr = null;
    	
    	try {
    		httpGet.setHeader("Content-Type", Content_Type);
    		httpGet.setHeader("User-Agent", User_Agent);
    		httpGet.setHeader("Cookie",cookie);
    		RequestConfig config = RequestConfig.custom().setRedirectsEnabled(false).build();
    		httpGet.setConfig(config);
    		response = httpClient.execute(httpGet);
    		int statusCode = response.getStatusLine().getStatusCode();
    		if (statusCode != HttpStatus.SC_OK) {
    			if(statusCode == HttpStatus.SC_MOVED_TEMPORARILY){
    				//重定向
    				 Header h = response.getFirstHeader("Location");
    		            if(h != null){
    		                HttpGet reHttpGet = new HttpGet(h.getValue());
    		                reHttpGet.setHeader("Cookie", cookie);
    		                reHttpGet.setConfig(config);
    		        		response = httpClient.execute(reHttpGet);
    		        		return StrKit.substring(response.getFirstHeader("Set-Cookie").getValue(), "STOKEN=", ";");
    		            }
    			}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	} finally {
    		if (response != null) {
    			try {
    				EntityUtils.consume(response.getEntity());
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	return httpStr;
    }
	/**
	 * 获取cookies
	 * @return Cookies
	 */
	public String getCookies() {
        StringBuilder sb = new StringBuilder();
        List<Cookie> list = this.getCookieStore().getCookies();
		for (Cookie cookie : list) {
			sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
		}
		return sb.toString();
    }
	
	/** 
	 * 构建header头信息 
	 * @param headerMaps headerMaps
	 * @return Header[]
	 */
    public Header[] build(HashMap<String, Header> headerMaps) {  
        Header[] headers = new Header[headerMaps.size()];  
        int i = 0;  
        for (Header header : headerMaps.values()) {  
            headers[i] = header;  
            i++;  
        }  
        headerMaps.clear();  
        headerMaps = null;  
        return headers;  
    } 
	
	public CookieStore getCookieStore() {
		return cookieStore;
	}

	public void setCookieStore(CookieStore cookieStore) {
		this.cookieStore = cookieStore;
	}
}
