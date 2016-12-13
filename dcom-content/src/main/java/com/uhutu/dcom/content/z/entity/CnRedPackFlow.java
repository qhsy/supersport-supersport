package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 人员打赏金额流水
 * @author 逄小帅
 *
 */
@Entity
public class CnRedPackFlow extends BaseEntity {
	
	@ZooData(value = "接收用户编号")
	private String reciveUserCode;
	
	@ZooData(value = "业务编号")
	private String busiCode;
	
	@ZooData(value = "打赏金额")
	private BigDecimal money;
	
	@ZooData(value = "红包编号")
	private String redPackCode;
	
	@ZooData(value = "打赏人员")
	private String sendUserCode;

	public String getReciveUserCode() {
		return reciveUserCode;
	}

	public void setReciveUserCode(String reciveUserCode) {
		this.reciveUserCode = reciveUserCode;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getSendUserCode() {
		return sendUserCode;
	}

	public void setSendUserCode(String sendUserCode) {
		this.sendUserCode = sendUserCode;
	}

	public String getRedPackCode() {
		return redPackCode;
	}

	public void setRedPackCode(String redPackCode) {
		this.redPackCode = redPackCode;
	}

}
