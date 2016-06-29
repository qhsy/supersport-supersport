package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信服务公众号配置信息
 * @author 逄小帅
 *
 */
public class WechatConfigResponse implements IPayResponse {
	
	/*微信公众号appid*/
	private String appId;
	
	/*生成签名时的时间戳*/
	private String timestamp;
	
	/*生成签名时的随机串*/
	private String nonceStr;
	
	/*签名*/
	private String signature;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
