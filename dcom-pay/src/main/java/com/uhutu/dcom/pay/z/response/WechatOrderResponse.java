package com.uhutu.dcom.pay.z.response;

/**
 * 微信统一下单响应对象
 * @author 逄小帅
 *
 */
public class WechatOrderResponse extends WechatResponse {
	
	/*交易类型*/
	private String trade_type;
	
	/*预支付会话id*/
	private String prepay_id;

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

}
