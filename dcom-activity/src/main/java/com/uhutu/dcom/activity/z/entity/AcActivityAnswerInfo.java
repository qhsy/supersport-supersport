package com.uhutu.dcom.activity.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 活动基本信息数据模型
 * 
 * @author xiegj
 *
 */
//@Entity
//@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
public class AcActivityAnswerInfo extends BaseEntity {

	@ZooData(name = "活动编号", inc = DefineWebInc.Insert_Code + "=ACBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(name = "活动名称", require = "1")
	@Column(length = 255)
	private String name;

	@ZooData(name = "活动价格", require = "1")
	private BigDecimal price;

	@ZooData(name = "活动状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd411310011001" }, require = "1")
	@Column(length = 30)
	private String status;

	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 20)
	private String startTime;

	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 20)
	private String endTime;

	@ZooData(name = "操作人", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String author;

	@ZooData(name = "活动备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
