package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片详情
 * 
 * @author xiegj
 *
 */
public class AdvertiseDetailForApi {
	@ApiModelProperty(name = "广告编号", notes = "广告编号", example = "gg01")
	private String code;

	@ApiModelProperty(name = "图片url", notes = "轮播图图片url", example = "http://www.ichsy.com")
	private String picUrl;

	@ApiModelProperty(name = "图片内容", notes = "图片内容")
	private String name;

	@ApiModelProperty(name = "图片超链接跳转类型", notes = "轮播图链接跳转类型dzsd4107100110050003:超链接,dzsd4107100110050002:内容详情页,dzsd4107100110050001:个人中心,dzsd4107100110050006:专题,dzsd4107100110050007:标签详情,dzsd4107100110050008:时刻列表,dzsd4107100110050009:问答列表,dzsd4107100110050010:活动报名,dzsd4107100110050011:直播", example = "01")
	private String piclinkType;

	@ApiModelProperty(name = "文章类型(piclinkType为dzsd4107100110050002时此参数有效)", notes = "dzsd4107100110030001:文章 ,dzsd4107100110030002:文章(含视频),dzsd4107100110030003:图集(piclinkType为dzsd4107100110050002时此参数有效),dzsd4107100110030004:单图,dzsd4107100110030005:单视频", example = "dzsd4107100110030001")
	private String type;

	@ApiModelProperty(name = "图片超链接跳转内容", notes = "轮播图链接跳转内容", example = "http://www.ichsy.com")
	private String piclinkContent;

	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String contentTitle;

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
