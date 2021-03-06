package com.uhutu.dcom.pay.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

@Entity
public class PaPayInfo extends BaseEntity {
	
	@ZooData(name="业务编号")
	@Column(length=50)
	private String busiCode;
	
	@ZooData(name="支付类型")
	@Column(length=50)
	private String payType;
	
	@ZooData(name="支付来源",comment="app,h5")
	@Column(length=50)
	private String paySource;
	
	@ZooData(name="支付金额")
	private BigDecimal money = BigDecimal.ZERO;
	
	@ZooData(name="业务类型")
	private String busiType;
	
	@ZooData(name="支付流水号")
	@Column(length=100)
	private String tradeNo;

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getPaySource() {
		return paySource;
	}

	public void setPaySource(String paySource) {
		this.paySource = paySource;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

}
