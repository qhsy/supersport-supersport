package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 栏目数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentItem extends BaseEntity {

	@ZooData(name = "栏目编号", inc = DefineWebInc.Insert_Code + "=LMBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "栏目名称")
	private String name;

	@ZooData(name = "发布状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	@ZooData(name = "排序(倒序)", element = DefineWebElement.Input, verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private String sort;

	@ZooData(name = "有效期(开始时间)", sort = { DefineWebPage.Page_Query + "=0" })
	private String startTime;

	@ZooData(name = "有效期(结束时间)", sort = { DefineWebPage.Page_Query + "=0" })
	private String endTime;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
