package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息点赞信息
 * @author 逄小帅
 *
 */
public class MsgPraiseInfo extends UserBasicInfo {
	
	@ApiModelProperty(name="点赞者")
	private String praiseUserCode;
	
	@ApiModelProperty(value="内容编号")
	private String contentCode;
	
	@ApiModelProperty(name="内容标题")
	private String contentTitle;
	
	@ApiModelProperty(value="内容背景缩略图")
	private String contentCover;
	
	@ApiModelProperty(value="内容类型",notes="dzsd4107100110030001:文章,dzsd4107100110030002:文章（含视频）,dzsd4107100110030003:图集,dzsd4107100110030004:单图,dzsd4107100110030005:图集")
	private String contentType;
	
	@ApiModelProperty(name="消息时间")
	private String msgTime;

	public String getPraiseUserCode() {
		return praiseUserCode;
	}

	public String getContentCover() {
		return contentCover;
	}

	public void setContentCover(String contentCover) {
		this.contentCover = contentCover;
	}

	public void setPraiseUserCode(String praiseUserCode) {
		this.praiseUserCode = praiseUserCode;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	
}
