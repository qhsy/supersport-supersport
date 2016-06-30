package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信授权请求信息
 * @author 逄小帅
 *
 */
public class WechatAuthRequest implements IPayRequest {
	
	/*公众号唯一标识*/
	private String appid;
	
	/*公众号的appsecret*/
	private String secret;
	
	/*填写第一步获取的code参数*/
	private String code;
	
	/*授权类型*/
	private String grant_type = "authorization_code";

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

}
