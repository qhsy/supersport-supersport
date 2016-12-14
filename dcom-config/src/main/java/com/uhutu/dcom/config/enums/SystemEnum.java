package com.uhutu.dcom.config.enums;

/**
 * 系统枚举
 * @author pang_jhui
 *
 */
public enum SystemEnum {
	
	YES("dzsd4699100110010001","是"),
	
	NO("dzsd4699100110010002","否"),
	
	NORMAL("1","正常"),
	
	INVALID("0","失效");
	
	private String code;
	
	private String name;
	
	private SystemEnum(String code,String name) {
		
		this.code = code;
		
		this.name = name;
		
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	

}
