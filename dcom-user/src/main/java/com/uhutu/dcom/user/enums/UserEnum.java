package com.uhutu.dcom.user.enums;

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
	FLAG_LOGINOUT("用户登录退出","4");	
	
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
