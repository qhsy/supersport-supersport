package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户注册
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUserRegSignInput extends RootApiInput {
	
	@ApiModelProperty(value = "用户名", notes = "用户名", example = "13512345678", required = true)
	private String loginName = "";
	
	@ApiModelProperty(value = "登录密码", notes = "登录密码", required = true)
	private String password = "";
	
	@ApiModelProperty(value = "验证码", notes = "验证码", required = true)
	private String verify_code = "";
	
	@ApiModelProperty(value="昵称",notes="昵称",required = true)
	private String nickName = "";
	
	@ApiModelProperty(value="设备编号")
	private String deviceId;
	
	@ApiModelProperty(value="随机数字符串")
	private String noneStr;
	
	@ApiModelProperty(value="签名")
	private String sign;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVerify_code() {
		return verify_code;
	}

	public void setVerify_code(String verify_code) {
		this.verify_code = verify_code;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
