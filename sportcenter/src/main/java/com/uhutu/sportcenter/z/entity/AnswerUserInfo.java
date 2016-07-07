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
	private BigDecimal charge = BigDecimal.ZERO;
	
	@ApiModelProperty(value="收入")
	private BigDecimal income = BigDecimal.ZERO;
	
	@ApiModelProperty(value="收益")
	private BigDecimal profit = BigDecimal.ZERO;
	
	@ApiModelProperty(value="用户问答状态",example="是：dzsd4699100110010001 否：dzsd4699100110010002")
	private String status;
	
	@ApiModelProperty(value="你擅长回答的问题")
	private String ability;
	
	@ApiModelProperty(value="是否已经关注",example="是：dzsd4699100110010001 否：dzsd4699100110010002")
	private String attendFlag;

	@ApiModelProperty(value="总共回答的问题数")
	private int answerCount;

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

	public String getAttendFlag() {
		return attendFlag;
	}

	public void setAttendFlag(String attendFlag) {
		this.attendFlag = attendFlag;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}

}
