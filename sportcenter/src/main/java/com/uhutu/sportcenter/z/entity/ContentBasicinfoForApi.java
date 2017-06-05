package com.uhutu.sportcenter.z.entity;

import java.util.Date;

import com.uhutu.dcom.component.z.util.CalendarUtil;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebVerify;

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

	@ZooData(name = "副标题", require = "1", verify = { DefineWebVerify.Max_Length + "=255" })
	private String ptitle;

	@ApiModelProperty(name = "日期展示", notes = "日期展示", example = "2016-4-19")
	private Date publishTime;

	@ApiModelProperty(name = "日期格式化", notes = "日期格式化字符串", example = "MM-dd HH:mm")
	private String publishTimeStr;

	@ApiModelProperty(name = "内容分享范围 ", notes = "dzsd4699100110010002:不公开  dzsd4699100110010001：公开")
	private String shareScope;

	@ApiModelProperty(name = "展示类型", notes = " dzsd4107100110030001:视频 ,dzsd4107100110030002:第三方直播,dzsd4107100110030003:专题")
	private String contentType;

	@ApiModelProperty(value = "评论数量")
	private long remarkNum;

	@ApiModelProperty(value = "喜欢标识")
	private boolean favorFlag;

	@ApiModelProperty(value = "预约标识")
	private boolean makeFlag;

	@ApiModelProperty(value = "能否预约")
	private boolean makeAble;

	@ApiModelProperty(name = "视频地址")
	private String videoUrl;

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

	public String getShareScope() {
		return shareScope;
	}

	public void setShareScope(String shareScope) {
		this.shareScope = shareScope;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPublishTimeStr() {

		String tempStr = "";

		if (getPublishTime() != null) {

			tempStr = CalendarUtil.timeStr(getPublishTime());

		}

		return tempStr;

	}

	public void setPublishTimeStr(String pattern) {

		if (getPublishTime() != null) {

			this.publishTimeStr = CalendarUtil.timeStr(getPublishTime());

		}

	}

	public boolean isFavorFlag() {
		return favorFlag;
	}

	public void setFavorFlag(boolean favorFlag) {
		this.favorFlag = favorFlag;
	}

	public long getRemarkNum() {
		return remarkNum;
	}

	public void setRemarkNum(long remarkNum) {
		this.remarkNum = remarkNum;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public boolean isMakeFlag() {
		return makeFlag;
	}

	public void setMakeFlag(boolean makeFlag) {
		this.makeFlag = makeFlag;
	}

	public String getPtitle() {
		return ptitle;
	}

	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}

	public boolean isMakeAble() {
		return makeAble;
	}

	public void setMakeAble(boolean makeAble) {
		this.makeAble = makeAble;
	}

}
