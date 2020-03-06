package com.github.libsgh.tieba.api;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.hutool.core.lang.Console;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;

public class TieBaLiveApi {
	
	/**
	 * 贴吧直播获取任务列表
	 * @param bduss
	 * @param stoken
	 * @return
	 */
	public static JSONObject taskList(String bduss, String stoken) {
		return commonRequest("http://c.tieba.baidu.com/ala/user/taskList", bduss, stoken);
	}
	
	/**
	 * 贴吧直播提交任务
	 * @param bduss
	 * @param stoken
	 * @param taskId
	 * @return
	 */
	public static JSONObject taskCommit(String bduss, String stoken, Integer taskId) {
		return commonRequest("http://c.tieba.baidu.com/ala/user/taskCommit", bduss, stoken, "task_id="+taskId);
	}
	
	/**
	 * 贴吧直播任务领取并开启下一阶段
	 * @param bduss
	 * @param stoken
	 * @param taskId
	 * @return
	 */
	public static JSONObject taskReward(String bduss, String stoken, Integer taskId) {
		return commonRequest("http://c.tieba.baidu.com/ala/user/taskReward", bduss, stoken, "task_id="+taskId);
	}
	
	/**
	 * 贴吧直播间赞
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject zan(String bduss, String stoken, String liveId) {
		return commonRequest("http://c.tieba.baidu.com/ala/live/zan", bduss, stoken, "is_first=1", "live_id="+liveId, "zan_type_id=1");
	}
	
	/**
	 * 贴吧直播首页大厅
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject tbLiveTab(String bduss, String stoken, Integer pn) {
		return commonRequest("http://c.tieba.baidu.com/c/f/video/tbLiveTab", bduss, stoken, "pn=1");
	}
	
	public static JSONObject getAlaScores(String bduss, String stoken) {
		return commonRequest("http://c.tieba.baidu.com/ala/user/getAlaScores", bduss, stoken);
	}
	
	/**
	 * 贴吧直播用户关注的主播
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject tbLiveTabUserLike(String bduss, String stoken, Integer pn) {
		return commonRequest("http://c.tieba.baidu.com/c/f/video/tbLiveTabUserLike", bduss, stoken, "pn=1");
	}
	
	public static JSONObject globalSwitchPush(String bduss, String stoken) {
		return commonRequest("http://c.tieba.baidu.com/ala/relation/globalSwitchPush", bduss, stoken, "switch=1");
	}
	
	/**
	 * 关注一个主播
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject follow(String bduss, String stoken, String portrait) {
		return commonRequest("http://c.tieba.baidu.com/c/c/user/follow", bduss, stoken, "portrait="+portrait,"in_live=1", "from_type=0");
	}
	
	/**
	 * 取消关注一个主播
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject unfollow(String bduss, String stoken, String portrait) {
		return commonRequest("http://c.tieba.baidu.com/c/c/user/unfollow", bduss, stoken, "portrait="+portrait);
	}
	
	/**
	 * 公共请求方法
	 * @param url
	 * @param bduss
	 * @param stoken
	 * @param params
	 * @return
	 */
	public static JSONObject commonRequest(String url, String bduss, String stoken, String... params) {
		HttpRequest request = HttpRequest.post(url)
				.form("BDUSS", bduss)
				.form("stoken", stoken)
				.form("_client_version", "10.3.8.1")
				.form("_client_type", 2)
				.form("timestamp", System.currentTimeMillis());
		for (String param : params) {
			request.form(StrUtil.subBefore(param, "=", false), StrUtil.subAfter(param, "=", false));
		}
		request.form("tbs", getTbs(bduss));
		Map<String, Object> formMap = request.form();
		formMap = MapUtil.sort(formMap);
		StringBuilder sb = new StringBuilder();
		for (String key : formMap.keySet()) {
			sb.append(String.format("%s=%s", key, formMap.get(key)).toString());
		}
		sb.append("tiebaclient!!!");
		String sign = SecureUtil.md5(sb.toString()).toUpperCase();
		String body = request.form("sign", sign).execute().body();
		if(StrUtil.isNotBlank(body)) {
			return JSON.parseObject(body);
		}
		return null;
	}
	
	/**
	 * 获取tbs
	 * @param bduss bduss
	 * @return tbs tbs
	 */
	public static String getTbs(String bduss){
		String result = HttpRequest.get("http://tieba.baidu.com/dc/common/tbs").cookie("BDUSS="+bduss).execute().body();
		return JSON.parseObject(result).getString("tbs");
	}
	
	/**
	 * 获取观众列表
	 * @param bduss
	 * @param stoken
	 * @param liveId
	 * @return
	 */
	public static JSONObject getAudienceList(String bduss, String stoken, String liveId){
		return commonRequest("http://c.tieba.baidu.com/ala/user/getAudienceList", bduss, stoken, "live_id="+liveId, "type=audience");
	}
	
	/**
	 * 获取贴吧所有主播
	 * @param bduss
	 * @param stoken
	 * @param pn
	 * @return
	 */
	public static JSONObject liveBarSpecialTab(String bduss, String stoken , Integer pn){
		return commonRequest("http://c.tieba.baidu.com/c/f/video/liveBarSpecialTab", bduss, stoken, "tab_name=推荐", "pn="+pn, "net_type=4");
	}
	
	public static String getUserProfile(String uid) {
		String result = "";
		try {
			if(StrUtil.isNotBlank(uid)) {
				//2.根据uid获取用户信息
				HttpRequest request = HttpRequest.post("http://c.tieba.baidu.com/c/u/user/profile")
												.form("_client_version", "6.1.2")
												.form("has_plist", "2")
												.form("need_post_count", "1")
												.form("uid", uid);
				Map<String, Object> formMap = request.form();
				formMap = MapUtil.sort(formMap);
				StringBuilder sb = new StringBuilder();
				for (String key : formMap.keySet()) {
					sb.append(String.format("%s=%s", key, formMap.get(key)).toString());
				}
				sb.append("tiebaclient!!!");
				String sign = SecureUtil.md5(sb.toString()).toUpperCase();
				String body = request.form("sign", sign).execute().body();
				return body;
			}else {
				Console.log("用户信息查找失败");
			}
		} catch (Exception e) {
			Console.error(e.getMessage(), e);
		}
	    return result;
	}
}