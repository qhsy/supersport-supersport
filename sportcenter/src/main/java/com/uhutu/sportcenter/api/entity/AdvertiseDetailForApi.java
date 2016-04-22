package com.uhutu.sportcenter.api.entity;

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

	@ApiModelProperty(name = "图片超链接跳转类型", notes = "轮播图链接跳转类型01:超链接,02:运动时刻详情页,03:个人中心", example = "01")
	private String piclinkType;

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
