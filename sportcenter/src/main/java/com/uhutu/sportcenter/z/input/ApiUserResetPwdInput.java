package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户重置密码输入参数
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUserResetPwdInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户名", notes = "用户名", example = "13512345678", required = true)
	private String loginName = "";
	
	@ApiModelProperty(value = "（新）登录密码", notes = "（新）登录密码", required = true)
	private String loginPwd = "";
	
	@ApiModelProperty(value="确认密码")
	private String confirmPwd;
	
	@ApiModelProperty(value="短信验证码",notes="短信验证码",required = true)
	private String verifyCode = "";
	
	@ApiModelProperty(value="校验类型",example="重置密码:resetpwd,忘记密码:forgetpwd")
	private String verifyType = "";

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getVerifyType() {
		return verifyType;
	}

	public void setVerifyType(String verifyType) {
		this.verifyType = verifyType;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

}
