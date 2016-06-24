package com.uhutu.dcom.pay.z.request;

import java.util.Date;
import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信业务内容请求
 * @author 逄小帅
 *
 */
public class WechatBizContentRequest implements IPayRequest {
	
	/*订单编号*/
	private String orderCode;
	
	/*商品描述*/
	private String body;
	
	/*订单有效开始时间*/
	private Date time_start;
	
	/*订单有效截止日期*/
	private Date time_expire; 
	
	/*请求地址*/
	private String requestIP;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getRequestIP() {
		return requestIP;
	}

	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getTime_start() {
		return time_start;
	}

	public void setTime_start(Date time_start) {
		this.time_start = time_start;
	}

	public Date getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(Date time_expire) {
		this.time_expire = time_expire;
	}

}
