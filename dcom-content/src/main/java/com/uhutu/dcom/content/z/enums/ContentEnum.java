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

	invalid("失效", "dzsd4699100110010002");

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
