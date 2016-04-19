package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @author xiegj
 *	短信验证码登录输入类
 */
public class ApiForLoginInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户名", notes = "用户名", example = "13512345678", required = true)
	private String loginName = "";

	@ApiModelProperty(value = "用户密码", required = true, example = "123456", notes = "用户的密码，长度为6-40位，支持特殊字符。")
	private String loginPass = "";

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	
}
