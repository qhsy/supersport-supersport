package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 钱包信息
 * @author 逄小帅
 *
 */
public class WalletInfo {
	
	@ApiModelProperty(value = "钱包可用收益")
	private BigDecimal profit = BigDecimal.ZERO;

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

}
