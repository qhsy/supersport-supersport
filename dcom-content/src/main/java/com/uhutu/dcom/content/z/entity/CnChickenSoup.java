package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 运动时刻小知识
 * 
 * @author xiegj
 *
 */
@Entity
public class CnChickenSoup extends BaseEntity {

	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=YDXZS", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(name = "小知识", element = DefineWebElement.Textarea, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, verify = { DefineWebVerify.Max_Length + "=280",
					DefineWebVerify.Min_Length + "=2" })
	@Column(length = 300)
	private String content;

	@ZooData(name = "发布状态", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	@Column(length = 5)
	private String status;

	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 30)
	private String startTime;

	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length = 30)
	private String endTime;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 200)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
