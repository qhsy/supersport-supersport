package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信公众号全局接口调用凭证
 * @author 逄小帅
 *
 */
public class WechatAccessTokenRequest implements IPayRequest {
	
	/*授权类型：默认client_credential*/
	private String grant_type = "client_credential";
	
	/*第三方用户唯一凭证*/
	private String appid;
	
	/*第三方用户唯一凭证密钥*/
	private String appsecret;

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

}
