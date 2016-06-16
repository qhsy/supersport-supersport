package com.uhutu.dcom.pay.z.response;

import java.math.BigDecimal;

/**
 * 支付宝业务内容请求
 * @author pang_jhui
 *
 */
public class AlipayBizContentResponse extends AlipayUnifyResponse {
	
	/*商户订单编号*/
	private String out_trade_no = "";

	/*支付宝服务器主动通知的路径*/
	private String notify_url = "";
	
	/*商品名称*/
	private String subject = "";
	
	/*支付类型。默认值为：1（商品购买）*/
	private String payment_type = "";
	
	/*卖家支付宝账号*/
	private String seller_id = "";
	
	/*总金额*/
	private BigDecimal total_fee = BigDecimal.ZERO;
	
	/*商品详情（length=512）*/
	private String body = "";
	
	/*未付款交易的超时时间*/
	private String it_b_pay = "";

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPayment_type() {
		return payment_type;
	}

	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}

	public String getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(String seller_id) {
		this.seller_id = seller_id;
	}

	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getIt_b_pay() {
		return it_b_pay;
	}

	public void setIt_b_pay(String it_b_pay) {
		this.it_b_pay = it_b_pay;
	}
	

}
