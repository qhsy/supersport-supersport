package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信h5支付请求信息
 * @author 逄小帅
 *
 */
public class WechatH5PayRequest implements IPayRequest {
	
	/*微信支付预付订单号*/
	private String prePayId;

	public String getPrePayId() {
		return prePayId;
	}

	public void setPrePayId(String prePayId) {
		this.prePayId = prePayId;
	}
	
}
