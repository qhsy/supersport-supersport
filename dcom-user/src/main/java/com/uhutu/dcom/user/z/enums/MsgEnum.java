package com.uhutu.dcom.user.z.enums;

/**
 * 消息枚举
 * @author 逄小帅
 *
 */
public enum MsgEnum {
	
	FLAG_UNREAD("0","未读"),
	
	FLAG_READ("1","已读");
	
	/**枚举编号*/
	private String code;
	
	/**枚举名称*/
	private String name;
	
	MsgEnum(String code,String name){
		
		setCode(code);
		
		setName(name);
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
