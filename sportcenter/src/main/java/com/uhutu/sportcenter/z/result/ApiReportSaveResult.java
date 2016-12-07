package com.uhutu.sportcenter.z.result;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiReportSaveResult extends RootApiResult {

	@ApiModelProperty(name = "支付订单编号", notes = "支付订单编号")
	private String orderCode = "";

	@ApiModelProperty(name = "支付金额", notes = "支付金额")
	private BigDecimal money = BigDecimal.ZERO;

	@ApiModelProperty(name = "支付类型", notes = "dzsd4112100110040001:支付宝,dzsd4112100110040002:微信")
	private String payType = "";

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

}
