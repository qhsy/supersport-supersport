package com.uhutu.dcom.content.z.entity.ext.ext;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片详情
 * 
 * @author xiegj
 *
 */
public class CnAdvertiseDetail extends BaseEntity {
	// @ZooData(name = "广告标题", sort = { DefineWebPage.Page_Query + "=0",
	// DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
	// DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc =
	// DefineWebInc.Url_Param + "=code")
	@ZooData(name = "图片编号", inc = { DefineWebInc.Insert_Code + "=GGTBH", DefineWebInc.Url_Param + "=code" }, sort = {
			DefineWebPage.Page_Add + "=1", DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process })
	@ApiModelProperty(name = "图片编号", notes = "图片编号", example = "ADBH0001")
	private String code;

	@ZooData(name = "图片内容", require = "1")
	@ApiModelProperty(name = "图片内容", notes = "图片内容")
	private String name;

	@ZooData(name = "图片(轮播:1080*608;单图:1080*420)", require = "1", element = DefineWebElement.Upload, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "图片", notes = "轮播图图片", example = "http://www.ichsy.com")
	private String picUrl;

	@ZooData(name = "跳转类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011015" }, comment = "选择‘URL’时,可设置分享,其它跳转类型不可分享")
	@ApiModelProperty(name = "图片超链接跳转类型", notes = "")
	private String piclinkType;

	@ZooData(name = "跳转内容")
	@ApiModelProperty(name = "图片超链接跳转内容", notes = "轮播图链接跳转内容", example = "http://www.ichsy.com")
	private String piclinkContent;

	@ZooData(name = "跳转后标题", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String contentTitle;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

}
