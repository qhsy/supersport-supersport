package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信用户请求
 * @author 逄小帅
 *
 */
public class WechatUserInfoRequest implements IPayRequest {
	
	/*网页授权接口调用凭证*/
	private String access_token;
	
	/*用户的唯一标识*/
	private String openid;
	
	/*返回国家地区语言版本*/
	private String lang="zh_CN";

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

}
