package com.github.libsgh.tieba.util;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * json工具类
 * @author libs
 * 2018-4-8
 */
public class JsonKit {
	
	@SuppressWarnings("unchecked")
	public static Object getInfo(String fieldName, String jsonString) {
		return ((Map<String, Object>) JSON.parse(jsonString)).get(fieldName);  
	}
	
	@SuppressWarnings("unchecked")
	public static Object getPInfo(String fieldName, String jsonPString){  
        int startIndex = jsonPString.indexOf("(");  
        int endIndex = jsonPString.lastIndexOf(")");  
        String json = jsonPString.substring(startIndex+1, endIndex);  
        return ((Map<String, Object>) JSON.parse(json)).get(fieldName);  
	}
	
}
