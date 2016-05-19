package com.uhutu.sportcenter.z.entity;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class ContentBasicinfoForApi {

	@ApiModelProperty(name = "内容编号")
	private String code;

	@ApiModelProperty(name = "内容封面图片链接", notes = "内容封面图片链接", example = "http://www.ichsy.com")
	private String cover;

	@ApiModelProperty(name = "标题", notes = "标题", example = "新体优家，您运动的首选~")
	private String title;

	@ApiModelProperty(name = "日期展示", notes = "日期展示", example = "2016-4-19")
	private Date publishTime;

	@ApiModelProperty(name = "内容简介")
	private String aboutDesc;

	@ApiModelProperty(name = "内容来源")
	private String souce;

	@ApiModelProperty(name = "内容状态 dzsd4699100110010001:正常，dzsd4699100110010002：失效")
	private String status;

	@ApiModelProperty(name = "内容分类编号")
	private String categoryCode;

	@ApiModelProperty(name = "标签编码")
	private String tagCode;

	@ApiModelProperty(name = "内容作者")
	private String author;

	@ApiModelProperty(name = "内容分享范围 dzsd4699100110010002:不公开  dzsd4699100110010001：公开")
	private String shareScope;

	@ApiModelProperty(name = "地理位置", notes = "位置经纬度", example = "116.404, 39.915")
	private String location;

	@ApiModelProperty(name = "地理位置名称", notes = "位置名称", example = "金域国际大厦")
	private String localtionName;

	@ApiModelProperty(name = "业务类型编号：运动时刻 文章", notes = "运动时刻:dzsd4699100110020001,文章:dzsd4699100110020002")
	private String busiType;

	@ApiModelProperty(name = "展示类型", notes = " dzsd4699100110030001:展示图文 dzsd4699100110030002:视频", example = "dzsd4699100110030002")
	private String contentType;

	@ApiModelProperty(name = "用户头像")
	private String aboutHead;

	@ApiModelProperty(name = "昵称")
	private String nickName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishTime() {
		return DateFormatUtils.format(this.publishTime, "MM-dd HH:mm");
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getSouce() {
		return souce;
	}

	public void setSouce(String souce) {
		this.souce = souce;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getShareScope() {
		return shareScope;
	}

	public void setShareScope(String shareScope) {
		this.shareScope = shareScope;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocaltionName() {
		return localtionName;
	}

	public void setLocaltionName(String localtionName) {
		this.localtionName = localtionName;
	}

	public String getBusiType() {
		return busiType;
	}

	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}

	public String getContentType() {
		return contentType;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

}
