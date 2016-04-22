package com.uhutu.dcom.content.enums;

/**
 * 内容枚举
 * @author pang_jhui
 *
 */
public enum ContentEnum {
	
	sportmoment("运动时刻","01"),
	
	article("文章","02");
	
	private String name = "";
	
	private String code = "";
	
	ContentEnum(String name, String code){
		
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
