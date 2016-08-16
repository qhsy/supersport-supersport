package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容评论信息
 * @author 逄小帅
 *
 */
public class ContentRemarkInfo extends UserBasicInfo {
	
	@ApiModelProperty(value="评论编号",notes="评论编号")
	private String code;
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String contentCode;
	
	@ApiModelProperty(value="内容类型",notes="dzsd4107100110030001:文章,dzsd4107100110030002:文章（含视频）,dzsd4107100110030003:图集,dzsd4107100110030004:单图,dzsd4107100110030005:图集")
	private String contentType;
	
	@ApiModelProperty(value="评论内容",notes="评论内容")
	private String remark;
	
	@ApiModelProperty(value="评论人用户编号",notes="评论人用户编号")
	private String author;
	
	@ApiModelProperty(value="评论的父级编号",notes="评论的父级编号")
	private String parentCode;
	
	@ApiModelProperty(value="评论状态",notes="评论状态")
	private String status;
	
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

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
