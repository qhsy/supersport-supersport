package com.uhutu.dcom.pay.z.response;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信授权响应信息
 * @author 逄小帅
 *
 */
public class WechatAuthResponse implements IPayResponse {
	
	/*网页授权接口调用凭证*/
	private String access_token;
	
	/*接口调用凭证超时时间*/
	private String expires_in;
	
	/*用户刷新access_token*/
	private String refresh_token;
	
	/*用户唯一标识*/
	private String openid;
	
	private String unionid;
	
	private String errcode;
	
	private String errmsg;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	/**
	 * 判断是否处理成功
	 * @return
	 */
	public boolean upFlag(){
		
		boolean flag = true;
		
		if(StringUtils.isNotBlank(getErrcode())){
			
			flag = false;
			
		}
		
		return flag;
		
	}

}
