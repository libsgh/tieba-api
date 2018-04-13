package com.tieba.model;

/**
 * 客户端类型（贴吧回帖）
 * @author libs
 * 2015-12-22 11:44
 */
public enum ClientType implements BaseEnum<Integer> {
	iphone(1, "iPhone" ),//苹果客户端
	android(2, "Android"),//安卓客户端
	wp(3, "WindowsPhone"),//wp客户端
	w8(4, "Windows 8");//win8/10客户端

	private int code;

	private String description;

	private ClientType(int _code, String description) {
		this.code = _code;
		this.description = description;
	}

	public Integer getCode() {
		return this.code;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {

		return String.valueOf(this.code);

	}

	// 通过属性获取对象
	public static ClientType getErrorCode(int code) {

		for (ClientType obj : ClientType.values()) {
			if (code == obj.getCode()) {

				return obj;
			}
		}

		return null;

	}

	public static String getName(int code) {

		for (ClientType obj : ClientType.values()) {
			if (code == obj.getCode()) {

				return obj.name();
			}
		}

		return null;

	}

	public static String getDescription(int code) {

		for (ClientType obj : ClientType.values()) {
			if (code == obj.getCode()) {

				return obj.getDescription();
			}
		}
		return null;

	}
}
