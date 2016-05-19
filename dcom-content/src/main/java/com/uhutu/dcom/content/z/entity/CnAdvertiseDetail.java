package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片详情
 * 
 * @author xiegj
 *
 */
@Entity
public class CnAdvertiseDetail extends BaseEntity {
	@ZooData(name = "广告编号", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010001" })
	@ApiModelProperty(name = "广告编号", notes = "广告编号", example = "ADBH0001")
	private String code;

	@ZooData(name = "图片", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@ApiModelProperty(name = "图片", notes = "轮播图图片", example = "http://www.ichsy.com")
	private String picUrl;

	@ZooData(name = "图片跳转类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011005" })
	@ApiModelProperty(name = "图片超链接跳转类型", notes = "轮播图链接跳转类型01:超链接,02:运动时刻详情页,03:个人中心")
	private String piclinkType;

	@ZooData(name = "图片跳转内容")
	@ApiModelProperty(name = "图片超链接跳转内容", notes = "轮播图链接跳转内容", example = "http://www.ichsy.com")
	private String piclinkContent;

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

}
