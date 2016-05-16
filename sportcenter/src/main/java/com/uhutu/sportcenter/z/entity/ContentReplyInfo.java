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

}
