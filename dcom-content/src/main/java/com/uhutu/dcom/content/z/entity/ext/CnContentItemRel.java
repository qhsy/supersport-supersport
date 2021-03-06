package com.uhutu.dcom.content.z.entity.ext;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 栏目与内容数据模型
 * 
 * @author xiegj
 *
 */
public class CnContentItemRel extends BaseEntity {

	@ZooData(name = "栏目名称", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=itemCode")
	private String itemCode;

	@ZooData(value = "栏目类型", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" }, element = DefineWebElement.Select, inc = {
					DefineWebInc.System_Define + "=dzsd410710011006" })
	private String itemType;

	@ZooData(name = "图片内容", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010009" })
	private String contentCode;

	@ZooData(name = "展示顺序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" })
	private String startTime;

	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" })
	private String endTime;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String remark;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
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
