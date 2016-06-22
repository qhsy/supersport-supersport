package com.uhutu.dcom.pay.z.request;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商户支付宝业务内容请求
 * @author pang_jhui
 *
 */
public class AlipayBizContentRequest extends AlipayUnifyRequest {
	
	/*订单编号*/
	private String orderCode;
	
	/*商品详情(length=512)*/
	private String body;
	
	/*商品名称*/
	private String subject;
	
	/*订单总金额*/
	private BigDecimal total_fee = BigDecimal.ZERO;
	
	/*订单有效时间*/
	private Date expire; 

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

	/**
	 * 获取商品详情
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 设置商品详情
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 获取商品名称
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 设置商品名称
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取总金额
	 * @return
	 */
	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	/**
	 * 设置总金额
	 * @param total_fee
	 */
	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * 订单有效时间
	 * @return
	 */
	public Date getExpire() {
		return expire;
	}

	/**
	 * 订单有效时间
	 * @param expire
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	
}
