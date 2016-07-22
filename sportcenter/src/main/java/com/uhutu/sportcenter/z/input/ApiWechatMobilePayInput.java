package com.uhutu.sportcenter.z.input;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信移动支付输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatMobilePayInput extends RootApiInput {
	
	@ApiModelProperty(value="订单编号")
	private String orderCode;
	
	@ApiModelProperty(value="服务ip")
	private String serveIP;
	
	@ApiModelProperty(value="终端IP")
	private String romoteIP;
	
	@ApiModelProperty(value="支付金额")
	private BigDecimal payMoney = BigDecimal.ZERO;

	public String getServeIP() {
		return serveIP;
	}

	public void setServeIP(String serveIP) {
		this.serveIP = serveIP;
	}

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

	public BigDecimal getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}

}
