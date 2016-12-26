package com.uhutu.dcom.content.z.entity.ext;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 栏目与内容数据模型
 * 
 * @author xiegj
 *
 */
public class CnHomeItemRel extends BaseEntity {

	@ZooData(name = "栏目名称", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=itemCode")
	private String itemCode;

	@ZooData(value = "栏目类型", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" }, element = DefineWebElement.Select, inc = {
					DefineWebInc.System_Define + "=dzsd410710011011" })
	private String itemType;

	@ZooData(name = "内容", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010002" })
	private String contentCode;

	@ZooData(name = "标签", verify = { DefineWebVerify.Max_Length + "=10" }, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Grid + "=0" })
	private String labelName;

	@ZooData(name = "自定义标题", require = "1", verify = { DefineWebVerify.Max_Length + "=50" })
	@ApiModelProperty(name = "标题", notes = "标题")
	private String title;

	@ZooData(name = "自定义封面", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;

	@ZooData(name = "内容作者", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String author;

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

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
