package com.uhutu.dcom.content.z.enums;

/**
 * 内容枚举
 * 
 * @author pang_jhui
 *
 */
public enum ContentEnum {

	sportmoment("运动时刻", "dzsd4107100110020001"),

	article("文章", "dzsd4107100110020002"),

	normal("有效", "dzsd4699100110010001"),

	invalid("失效", "dzsd4699100110010002"),
	
	FAVOR_TYPE_LIKE("喜欢","01"),
	
	FAVOR_TYPE_HATE("讨厌","02"),
	
	FAVOR_STATUS_YES("喜欢","1"),
	
	FAVOR_STATUS_NO("不喜欢","0"),
	
	LIVEREADY("准备直播","2"),
	
	LIVEING("直播中","1"),
	
	LIVEEND("直播结束","0"),
	
	TYPE_LIVE("直播","dzsd4107100110030007"),
	
	MATCH_PUB("已发布","dzsd4107100110130002"),
	
	MATCH_UNP("未发布","dzsd4107100110130001"),
	
	BIZID("bizid","5294"),
	
	BIZKEY("bizkey","0e5cdd97c4ae7a3f0c7497de7728ee78");

	private String name = "";

	private String code = "";

	ContentEnum(String name, String code) {

		setCode(code);

		setName(name);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
