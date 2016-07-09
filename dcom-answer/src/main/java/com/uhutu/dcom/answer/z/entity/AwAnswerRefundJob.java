package com.uhutu.dcom.answer.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 微信退款任务
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwAnswerRefundJob extends BaseEntity {

	@ZooData(value = "退款编号")
	@Column(length = 50)
	private String code;

	@ZooData(value = "订单编号")
	@Column(length = 50)
	private String orderCode;

	@ZooData(value = "微信授权登录openid")
	@Column(length = 50)
	private String wechatOpenId;

	@ZooData(value = "退款总金额 (RMB)")
	private BigDecimal amount;

	@ZooData(value = "未退款金额 (RMB)")
	private BigDecimal unAmount;

	@ZooData(value = "已退金额")
	private BigDecimal alAmount;

	@ZooData(value = "状态", demo = "0:已完成,1:未完成")
	@Column(length = 50)
	private String status;

	@ZooData(value = "备注")
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getUnAmount() {
		return unAmount;
	}

	public void setUnAmount(BigDecimal unAmount) {
		this.unAmount = unAmount;
	}

	public BigDecimal getAlAmount() {
		return alAmount;
	}

	public void setAlAmount(BigDecimal alAmount) {
		this.alAmount = alAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
