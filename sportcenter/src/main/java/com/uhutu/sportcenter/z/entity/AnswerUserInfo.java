package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问答用户信息
 * @author 逄小帅
 *
 */
public class AnswerUserInfo extends UserBasicInfo {
	
	@ApiModelProperty(value="提问收费")
	private BigDecimal charge;
	
	@ApiModelProperty(value="收入")
	private BigDecimal income;
	
	@ApiModelProperty(value="收益")
	private BigDecimal profit;
	
	@ApiModelProperty(value="用户问答状态")
	private String status;
	
	@ApiModelProperty(value="你擅长回答的问题")
	private String ability;

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

}
