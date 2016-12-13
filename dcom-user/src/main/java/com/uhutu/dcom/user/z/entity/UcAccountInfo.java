package com.uhutu.dcom.user.z.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户账户信息
 * @author 逄小帅
 *
 */
@Entity
public class UcAccountInfo extends BaseEntity {
	
	@ZooData(value = "用户编号")
	private String userCode;
	
	@ZooData(value="可用收益")
	private BigDecimal profit;
	
	@ZooData(value="累计收益")
	private BigDecimal totalProfit;
	
	@ZooData(value="可用余额")
	private BigDecimal balance;
	
	@ZooData(value="充值金额")
	private BigDecimal charge;
	
	@ZooData(value="冻结金额")
	private BigDecimal freeze;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getFreeze() {
		return freeze;
	}

	public void setFreeze(BigDecimal freeze) {
		this.freeze = freeze;
	}

}
