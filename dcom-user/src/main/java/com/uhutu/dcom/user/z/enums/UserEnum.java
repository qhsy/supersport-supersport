package com.uhutu.dcom.user.z.enums;

/**
 * 用户枚举类型
 * @author pang_jhui
 *
 */
public enum UserEnum {
	
	/**用户状态：有效*/
	FLAG_ENABLE("用户有效","1"),
	
	/**用户状态：失效*/
	FLAG_DISABLE("用户失效","0"),
	
	/**用户状态：冻结*/
	FLAG_FREEZE("用户冻结","2"),
	
	/**用户装填：已登录*/
	FLAG_LOGIN("用户登录","3"),
	
	/**用户装填：已登录*/
	FLAG_LOGINOUT("用户登录退出","4"),
	
	/**普通用户*/
	TYPE_CUSTOM("普通用户","01"),
	
	/**达人用户*/
	TYPE_EXPERT("达人用户","02"),
	
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
	OPER_SOCIAL("社交类用户","social");	
	
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
