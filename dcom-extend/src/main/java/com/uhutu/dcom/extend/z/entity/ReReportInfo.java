package com.uhutu.dcom.extend.z.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 报表主表
 * 
 * @author xiegj
 *
 */
@Entity
public class ReReportInfo extends BaseEntity {

	@ZooData(name = "报表编号",inc = DefineWebInc.Url_Param + "=code")
	private String code;

	@ZooData(name = "报表标题")
	private String title;

	@ZooData(name = "开始时间",element = DefineWebElement.Datehms)
	private Date startTime;

	@ZooData(name = "结束时间",element = DefineWebElement.Datehms)
	private Date endTime;

	@ZooData(name = "支付类型",sort = {DefineWebPage.Page_Grid+"=0",DefineWebPage.Page_Query+"=0"}, demo = "dzsd4112100110040001:支付宝,dzsd4112100110040002:微信")
	@Column(length = 50)
	private String payType;

	@ZooData(name = "需支付金额",sort={DefineWebPage.Page_Query+"=0"})
	private BigDecimal orderMoney;

	@ZooData(name = "简介",sort = {DefineWebPage.Page_Query+"=0"})
	private String remark;

	@ZooData(name = "发布状态 1:正常，0：失效",sort = {DefineWebPage.Page_Grid+"=0",DefineWebPage.Page_Query+"=0"})
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

}
