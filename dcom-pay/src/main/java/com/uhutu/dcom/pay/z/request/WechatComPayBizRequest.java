package com.uhutu.dcom.pay.z.request;

import java.math.BigDecimal;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信企业支付业务请求
 * @author 逄小帅
 *
 */
public class WechatComPayBizRequest implements IPayRequest {
	
	/*远端IP地址*/
	private String romoteIP;
	
	/*商户订单编号*/
	private String orderCode;
	
	/*用户openid*/
	private String openid;
	
	/*退款金额*/
	private BigDecimal amount = BigDecimal.ZERO;
	
	/*企业付款备注*/
	private String remark;

	public String getRomoteIP() {
		return romoteIP;
	}

	public void setRomoteIP(String romoteIP) {
		this.romoteIP = romoteIP;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
