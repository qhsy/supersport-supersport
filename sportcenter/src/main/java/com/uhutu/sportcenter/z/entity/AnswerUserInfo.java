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
	
	@ApiModelProperty(value="是否已经关注",example="如果获取的用户信息不是自己，则使用本参数,1:已关注，0:未关注")
	private String attendFlag;

	@ApiModelProperty(value="总共回答的问题数")
	private int answerCount;
	
	@ApiModelProperty(value="头衔")
	private String title;
	
	@ApiModelProperty(value="粉丝数量")
	private int fansNum;
	
	@ApiModelProperty(value="关注数量")
	private int attendNum;
	
	@ApiModelProperty(value="运动时刻数量")
	private int momentNum;
	
	@ApiModelProperty(value="喜欢的运动时刻数量")
	private int favorNum;
	
	@ApiModelProperty(value="是否绑定结算账户")
	private boolean settleFlag = false;
	
	@ApiModelProperty(value="结算账户名称")
	private String settleAccountName;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFansNum() {
		return fansNum;
	}

	public void setFansNum(int fansNum) {
		this.fansNum = fansNum;
	}

	public int getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}

	public int getMomentNum() {
		return momentNum;
	}

	public void setMomentNum(int momentNum) {
		this.momentNum = momentNum;
	}

	public int getFavorNum() {
		return favorNum;
	}

	public void setFavorNum(int favorNum) {
		this.favorNum = favorNum;
	}

	public boolean isSettleFlag() {
		return settleFlag;
	}

	public void setSettleFlag(boolean settleFlag) {
		this.settleFlag = settleFlag;
	}

	public String getSettleAccountName() {
		return settleAccountName;
	}

	public void setSettleAccountName(String settleAccountName) {
		this.settleAccountName = settleAccountName;
	}

}
