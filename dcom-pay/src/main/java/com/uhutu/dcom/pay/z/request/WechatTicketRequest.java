package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * jsapi ticket请求信息
 * @author 逄小帅
 *
 */
public class WechatTicketRequest implements IPayRequest {
	
	/*接口访问token*/
	private String access_token;
	
	/*类型*/
	private String type;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
