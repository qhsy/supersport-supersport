package com.uhutu.dcom.user.z.enums;

/**
 * 消息枚举
 * @author 逄小帅
 *
 */
public enum MsgEnum {
	
	/**未读*/
	FLAG_UNREAD("0","未读"),
	
	/**已读*/
	FLAG_READ("1","已读"),
	
	/**关注*/
	ATTEND("01","关注"),
	
	/**评论*/
	REMARK("02","评论"),
	
	/**通知*/
	NOTICE("03","通知"),
	
	/**点赞*/
	PRAISE("04","点赞"),
	
	TYPE_SYSTEM("system","系统消息"),
	
	TYPE_ANSWER("answer","问答助手");
	
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
