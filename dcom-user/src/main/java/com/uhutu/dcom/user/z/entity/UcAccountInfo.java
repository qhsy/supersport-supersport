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
	
	@ZooData(value="收益")
	private BigDecimal profit;

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

}
