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
	
	@ApiModelProperty(value="内容类型",notes="dzsd4107100110030001:文章,dzsd4107100110030002:文章（含视频）,dzsd4107100110030003:图集,dzsd4107100110030004:单图,dzsd4107100110030005:图集")
	private String contentType;
	
	@ApiModelProperty(value="内容作者昵称")
	private String authorName;

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
