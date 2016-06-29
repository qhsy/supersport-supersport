package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信公众号全局接口条用凭证
 * @author 逄小帅
 *
 */
public class WechatAccessTokenResponse implements IPayResponse {

	/*获取到的凭证*/
	private String access_token;
	
	/*凭证有效时间*/
	private Long expires_in;
	
	/*错误编码*/
	private int errcode;
	
	/*错误信息*/
	private String errmsg;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	
	
	
}
