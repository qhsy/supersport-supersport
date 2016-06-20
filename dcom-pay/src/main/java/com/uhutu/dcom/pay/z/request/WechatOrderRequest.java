package com.uhutu.dcom.pay.z.request;

import java.math.BigDecimal;

/**
 * 微信统一下单请求信息
 * @author 逄小帅
 *
 */
public class WechatOrderRequest extends WechatUnifyRequest {
	
	/*商品描述*/
	private String body;
	
	/*商户订单编号*/
	private String out_trade_no;
	
	/*总金额*/
	private BigDecimal total_fee = BigDecimal.ZERO;
	
	/*交易起始时间 yyyyMMddHHmmss*/
	private String time_start;
	
	/*交易结束时间：最短时间间隔必须大于五分钟*/
	private String time_expire;
	
	/*通知地址*/
	private String notify_url;
	
	/*支付类型*/
	private String trade_type;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public BigDecimal getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(BigDecimal total_fee) {
		this.total_fee = total_fee;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

}
