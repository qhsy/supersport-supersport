package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信业务内容请求
 * @author 逄小帅
 *
 */
public class WechatBizContentRequest implements IPayRequest {
	
	/*订单编号*/
	private String orderCode;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

}
