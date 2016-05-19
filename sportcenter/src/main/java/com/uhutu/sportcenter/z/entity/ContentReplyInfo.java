package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容回复信息
 * @author 逄小帅
 *
 */
public class ContentReplyInfo {
	
	@ApiModelProperty(value="回复信息")
	private ContentRemarkInfo replyInfo;
	
	@ApiModelProperty(value="引用的回复信息")
	private ContentRemarkInfo refReplyInfo;
	
	@ApiModelProperty(value="内容标题")
	private String contentTitle;

	public ContentRemarkInfo getReplyInfo() {
		return replyInfo;
	}

	public void setReplyInfo(ContentRemarkInfo replyInfo) {
		this.replyInfo = replyInfo;
	}

	public ContentRemarkInfo getRefReplyInfo() {
		return refReplyInfo;
	}

	public void setRefReplyInfo(ContentRemarkInfo refReplyInfo) {
		this.refReplyInfo = refReplyInfo;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

}
