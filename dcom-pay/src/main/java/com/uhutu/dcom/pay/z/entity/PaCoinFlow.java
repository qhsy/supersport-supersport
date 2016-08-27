package com.uhutu.dcom.pay.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 金币流水信息
 * @author 逄小帅
 *
 */
@Entity
public class PaCoinFlow extends BaseEntity {
	
	@ZooData(name = "流水编号")
	@Column(length = 50)
	private String code;
	
	@ZooData(name = "交易类型")
	@Column(length = 50)
	private String tradeType;
	
	@ZooData(name = "交易数量")
	private long tradeNum;
	
	@ZooData(name = "外部编号")
	@Column(length = 50)
	private String outCode;
	
	@ZooData(name = "备注信息")
	private String remark;
	
	@ZooData(name="操作类型")
	private String operType;
	
	@ZooData(name="用户编号")
	private String userCode;

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

	public long getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(long tradeNum) {
		this.tradeNum = tradeNum;
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

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
