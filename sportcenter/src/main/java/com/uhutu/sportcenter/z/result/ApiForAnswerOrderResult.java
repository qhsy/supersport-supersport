package com.uhutu.sportcenter.z.result;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForAnswerOrderResult extends RootApiResult {

	@ApiModelProperty(name = "订单金额")
	private BigDecimal orderMoney = BigDecimal.ZERO;

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

}
