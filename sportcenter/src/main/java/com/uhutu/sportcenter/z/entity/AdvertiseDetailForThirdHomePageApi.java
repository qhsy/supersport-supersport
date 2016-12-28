package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 图片详情
 * 
 * @author xiegj
 *
 */
public class AdvertiseDetailForThirdHomePageApi {
	@ApiModelProperty(name = "广告编号", notes = "广告编号", example = "gg01")
	private String code;

	@ApiModelProperty(name = "图片url", notes = "轮播图图片url", example = "http://www.ichsy.com")
	private String picUrl;

	@ApiModelProperty(name = "图片内容", notes = "图片内容")
	private String name;

	@ApiModelProperty(name = "缺省图片", notes = "缺省图片")
	private String defaultPicUrl;
	
	@ApiModelProperty(name = "图片超链接跳转类型", notes = "dzsd4107100110150001:内容详情,dzsd4107100110150002:个人主页,dzsd4107100110150003:URL,dzsd4107100110150004:标签详情,dzsd4107100110150005:赛事详情", example = "01")
	private String piclinkType;

	@ApiModelProperty(name = "图片超链接跳转内容", notes = "轮播图链接跳转内容", example = "http://www.ichsy.com")
	private String piclinkContent;

	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String contentTitle;

	@ApiModelProperty(value = "昵称")
	private String nick_name;

	@ApiModelProperty(name = "标签", notes = "标签")
	private String labelName;

	@ApiModelProperty(name = "标题", notes = "标题")
	private String title;

	@ApiModelProperty(name = "跳转类")
	private JumpTypeData jump;

	public JumpTypeData getJump() {
		return jump;
	}

	public void setJump(JumpTypeData jump) {
		this.jump = jump;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getLabelName() {
		return labelName;
	}

	public String getDefaultPicUrl() {
		return defaultPicUrl;
	}

	public void setDefaultPicUrl(String defaultPicUrl) {
		this.defaultPicUrl = defaultPicUrl;
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

}
