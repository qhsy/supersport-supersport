package com.uhutu.dcom.user.z.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户交易流水
 * @author 逄小帅
 *
 */
@Entity
public class UcTradeFlow extends BaseEntity {
	
	@ZooData(name = "流水编号")
	@Column(length = 50)
	private String code;
	
	@ZooData(name = "交易类型",comment="余额、三方支付")
	@Column(length = 50)
	private String tradeType;
	
	@ZooData(name = "交易金额")
	private BigDecimal tradeMoney;
	
	@ZooData(name = "外部编号")
	@Column(length = 50)
	private String outCode;
	
	@ZooData(name = "备注信息")
	private String remark;
	
	@ZooData(name="操作类型",comment="打赏、充值、提现")
	private String operType;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public BigDecimal getTradeMoney() {
		return tradeMoney;
	}

	public void setTradeMoney(BigDecimal tradeMoney) {
		this.tradeMoney = tradeMoney;
	}

	public String getOutCode() {
		return outCode;
	}

	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}
	
	
}
