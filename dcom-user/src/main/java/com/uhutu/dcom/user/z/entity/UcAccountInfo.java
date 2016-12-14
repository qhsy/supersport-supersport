package com.uhutu.dcom.user.z.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户账户信息
 * 
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode" }))
public class UcAccountInfo extends BaseEntity {

	@ZooData(value = "用户昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String userCode;

	@ZooData(value = "可用收益", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal profit = BigDecimal.ZERO;

	@ZooData(value = "累计收益", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal totalProfit = BigDecimal.ZERO;

	@ZooData(value = "可用余额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal balance = BigDecimal.ZERO;

	@ZooData(value = "充值金额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal charge = BigDecimal.ZERO;

	@ZooData(value = "冻结金额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal freeze = BigDecimal.ZERO;

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
