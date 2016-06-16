package com.uhutu.dcom.pay.z.request;

/**
 * 商户支付宝业务内容请求
 * @author pang_jhui
 *
 */
public class AlipayBizContentRequest extends AlipayUnifyRequest {
	
	/*订单编号*/
	private String orderCode;

	/**
	 * 获取订单编号
	 * @return 订单编号
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置订单编号
	 * @param orderCode
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
}
