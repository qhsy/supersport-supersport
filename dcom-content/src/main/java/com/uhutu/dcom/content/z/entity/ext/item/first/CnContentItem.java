package com.uhutu.dcom.content.z.entity.ext.item.first;

import javax.persistence.Column;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 栏目数据模型（导航栏专用）
 * 
 * @author xiegj
 *
 */
public class CnContentItem extends BaseEntity {

	@ZooData(name = "栏目编号", inc = DefineWebInc.Insert_Code + "=LMBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "栏目名称", require = "1")
	private String name;

	@ZooData(value = "栏目类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011006" }, sort = { DefineWebPage.Page_Query + "=0",
					DefineWebPage.Page_Grid + "=0", DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String type;

	@ZooData(name = "栏目图标(宽:待定;高:待定)", require = "1", element = DefineWebElement.Upload, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "栏目图标", notes = "栏目图标", example = "http://www.ichsy.com")
	private String picUrl;

	@ZooData(value = "是否显示更多", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=10" }, demo = "1:显示,0:不显示")
	@Column(length = 50)
	@ApiModelProperty(name = "是否显示更多1:显示,0:不显示", notes = "是否显示更多1:显示,0:不显示")
	private String moreStatus;

	@ZooData(name = "更多内容", sort = { DefineWebPage.Page_Query + "=0" })
	@ApiModelProperty(name = "更多内容", notes = "更多内容", example = "http://www.ichsy.com")
	private String contentTitle;

	@ZooData(name = "更多跳转类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011005" }, sort = { DefineWebPage.Page_Query + "=0" })
	@ApiModelProperty(name = "更多跳转类型", notes = "轮播图链接跳转类型dzsd4107100110050003:超链接,dzsd4107100110050002:内容详情页,dzsd4107100110050001:个人中心,dzsd4107100110050006:专题,dzsd4107100110050007:标签详情,dzsd4107100110050008:时刻列表,dzsd4107100110050009:问答列表")
	private String piclinkType;

	@ZooData(name = "更多跳转参数", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "更多跳转参数", notes = "更多跳转参数", example = "http://www.ichsy.com")
	private String piclinkContent;

	@ZooData(name = "跳转后标题", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String piclinkTitle;

	@ZooData(name = "栏目发布状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	@ZooData(name = "排序(倒序)", element = DefineWebElement.Input, verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" }, require = "1")
	private int sort;

	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1")
	private String startTime;

	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1")
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

	public String getMoreStatus() {
		return moreStatus;
	}

	public void setMoreStatus(String moreStatus) {
		this.moreStatus = moreStatus;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getPiclinkTitle() {
		return piclinkTitle;
	}

	public void setPiclinkTitle(String piclinkTitle) {
		this.piclinkTitle = piclinkTitle;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getPiclinkType() {
		return piclinkType;
	}

	public void setPiclinkType(String piclinkType) {
		this.piclinkType = piclinkType;
	}

	public String getPiclinkContent() {
		return piclinkContent;
	}

	public void setPiclinkContent(String piclinkContent) {
		this.piclinkContent = piclinkContent;
	}

}
