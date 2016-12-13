package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 人员打赏金额流水
 * 
 * @author 逄小帅
 *
 */
@Entity
public class CnRedPackFlow extends BaseEntity {

	@ZooData(value = "接受打赏者", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length = 50)
	private String reciveUserCode;

	@ZooData(value = "业务编号")
	@Column(length = 50)
	private String busiCode;

	@ZooData(value = "打赏金额")
	private BigDecimal money;

	@ZooData(value = "红包编号")
	@Column(length = 50)
	private String redPackCode;

	@ZooData(value = "打赏者", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length = 50)
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
