package com.github.libsgh.tieba.util;


/**
 * 字符串工具类
 * @author libs
 * 2018-4-8
 */
public class StrKit {
	
    /**
     * 截取字符串
     * @param str 原字符串
     * @param s1 起始字符串
     * @param s2 结束字符串
     * @return String
     */
    public static String substring(String str, String s1, String s2) {
		// 1、先获得0-s1的字符串，得到新的字符串sb1
		// 2、从sb1中开始0-s2获得最终的结果。
		try {
			StringBuffer sb = new StringBuffer(str);
			String sb1 = sb.substring(sb.indexOf(s1) + s1.length());
			return String.valueOf(sb1.substring(0, sb1.indexOf(s2)));
		} catch (StringIndexOutOfBoundsException e) {
			return str;
		}
	}
    
    /**
     * 字符串为 null 或者内部字符全部为 ' ' '\t' '\n' '\r' 这四类字符时返回 true
     * @param str 字符串
     * @return boolean
     */
	public static boolean isBlank(String str) {
		if (str == null) {
			return true;
		}
		int len = str.length();
		if (len == 0) {
			return true;
		}
		for (int i = 0; i < len; i++) {
			switch (str.charAt(i)) {
			case ' ':
			case '\t':
			case '\n':
			case '\r':
			// case '\b':
			// case '\f':
				break;
			default:
				return false;
			}
		}
		return true;
	}
	
    public static boolean notBlank(String str) {
		return !isBlank(str);
	}
	
	public static boolean notBlank(String... strings) {
		if (strings == null) {
			return false;
		}
		for (String str : strings) {
			if (isBlank(str)) {
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args) {
		String aa = substring("err_no=257&callback=&codeString=jxG7d06c1cb9a79e24402bb14244301457ec6ec980733047b41&userName=809858853%40qq.com&phoneNumber=&mail=&hao", "codeString=", "&");
		System.out.println(aa);
    }
}
