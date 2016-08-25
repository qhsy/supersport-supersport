package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 
 * @author xiegj
 *	短信验证码登录输入类
 */
@ApiModel
public class ApiSignLoginInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户名", notes = "用户名", example = "13512345678", required = true)
	private String loginName = "";

	@ApiModelProperty(value = "用户密码", required = true, example = "123456", notes = "用户的密码，长度为6-40位，支持特殊字符。")
	private String loginPass = "";
	
	@ApiModelProperty(value="随机字符串")
	private String noneStr;
	
	@ApiModelProperty(value="签名")
	private String sign;

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

	public String getNoneStr() {
		return noneStr;
	}

	public void setNoneStr(String noneStr) {
		this.noneStr = noneStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
