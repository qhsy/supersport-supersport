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
	
	FAVOR_STATUS_NO("不喜欢","0");

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
