package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * h5调起支付响应信息
 * @author 逄小帅
 *
 */
public class WechatH5PayResponse implements IPayResponse {
	
	/*公众号id*/
	private String appId;
	
	/*时间戳*/
	private String timeStamp;
	
	/*随机字符串*/
	private String nonceStr;
	
	/*订单详情扩展字符串*/
	private String prepay_id;
	
	/*签名方式*/
	private String signType;
	
	/*签名*/
	private String paySign;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getPaySign() {
		return paySign;
	}

	public void setPaySign(String paySign) {
		this.paySign = paySign;
	}

}
