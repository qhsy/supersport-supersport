package com.uhutu.dcom.answer.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 微信退款流水
 * 
 * @author xiegj
 *
 */
@Entity
public class AwAnswerRefundLog extends BaseEntity {

	@ZooData(value = "退款编号")
	@Column(length = 50)
	private String code;

	@ZooData(value = "本次退款金额 ")
	private BigDecimal amount;

	@ZooData(value = "退款时间")
	private String time;

	@ZooData(value = "状态", demo = "0:退款失败,1:退款成功")
	@Column(length = 50)
	private String status;

	@ZooData(value = "请求结果", demo = "")
	@Column(length = 50)
	private String response;

	@ZooData(value = "备注")
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
