package com.uhutu.dcom.user.z.enums;

/**
 * 用户枚举类型
 * @author pang_jhui
 *
 */
public enum UserEnum {
	
	/**用户状态：有效*/
	FLAG_ENABLE("用户有效","dzsd4107100410010002"),
	
	/**用户状态：失效*/
	FLAG_DISABLE("用户失效","dzsd4107100410010001"),
	
	/**用户状态：冻结*/
	FLAG_FREEZE("用户冻结","dzsd4107100410010003"),
	
	/**普通用户*/
	TYPE_CUSTOM("普通用户","dzsd4107100310010001"),
	
	/**达人用户*/
	TYPE_EXPERT("达人用户","dzsd4107100310010002"),
	/**企业认证*/
	TYPE_COMPANY("企业认证","dzsd4107100310010003"),
	/**关注*/
	ATTEND("关注","1"),
	
	/**取消关注*/
	UN_ATTEND("取消关注","0"),
	
	/**自身*/
	OPER_OWN("自身","own"),
	
	/**其他用户*/
	OPER_OTHER("其他用户","other"),
	
	/**操作普通用户*/
	OPER_CUSTOM("普通用户","custom"),
	
	/**操作社交用户*/
	OPER_SOCIAL("社交类用户","social"),
	
	/**操作社交用户*/
	OPER_WECHAT("微信用户","wechat"),
	
	/**掩码*/
	SALT("掩码","38D7A2F32F7B8B2571F9C3E37C933BB9");	
	
	private String code = "";
	
	private String name = "";
	
	private UserEnum(String name, String code){
		
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
