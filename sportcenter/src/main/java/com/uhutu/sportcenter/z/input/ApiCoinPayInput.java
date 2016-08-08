package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金币支付输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiCoinPayInput extends RootApiInput {
	
	@ApiModelProperty(value="支付金币数量")
	private long coinNum;
	
	@ApiModelProperty(value="订单编号")
	private String orderCode;

	public long getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(long coinNum) {
		this.coinNum = coinNum;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}
	
	

}
