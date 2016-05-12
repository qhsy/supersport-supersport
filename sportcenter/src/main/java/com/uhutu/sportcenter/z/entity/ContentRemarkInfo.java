package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容评论信息
 * @author 逄小帅
 *
 */
public class ContentRemarkInfo {
	
	@ApiModelProperty(value="评论编号",notes="评论编号")
	private String code;
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String contentCode;
	
	@ApiModelProperty(value="评论内容",notes="评论内容")
	private String remark;
	
	@ApiModelProperty(value="评论人用户编号",notes="评论人用户编号")
	private String author;
	
	@ApiModelProperty(value="评论人用户名称",notes="评论人用户名称")
	private String authorName;
	
	@ApiModelProperty(value="评论的父级编号",notes="评论的父级编号")
	private String parentCode;
	
	@ApiModelProperty(value="父级评论的用户名称",notes="评论的用户名称",example="@帅帅")
	private String replyName;
	
	@ApiModelProperty(value="评论状态",notes="评论状态")
	private String status;
	
	@ApiModelProperty(value="用户头像")
	private String headUrl;
	
	@ApiModelProperty(value="发布时间")
	private String publishTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReplyName() {
		return replyName;
	}

	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

}
