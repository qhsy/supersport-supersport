package com.uhutu.dcom.answer.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问答达人用户信息
 * @author 逄小帅
 *
 */
//@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode" }))
public class AwAnswerExpert extends BaseEntity {
	
	@ZooData(name="用户编号")
	@Column(length=50)
	private String userCode;
	
	@ZooData(name="提问收费")
	private BigDecimal charge;
	
	@ZooData(name="收入")
	private BigDecimal income;
	
	@ZooData(name="收益")
	private BigDecimal profit;
	
	@ZooData(name="用户问答状态")
	@Column(length=50)
	private String status;
	
	@ZooData(name="你擅长回答的问题")
	private String ability;
	
	@ZooData(name="头衔")
	@Column(length=50)
	private String title;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public BigDecimal getIncome() {
		
		if(income == null){
			
			income = BigDecimal.ZERO;
			
		}
		
		return income;
	}

	public void setIncome(BigDecimal income) {
		this.income = income;
	}

	public BigDecimal getProfit() {
		
		if(profit == null){
			
			profit = BigDecimal.ZERO;
			
		}
		
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
