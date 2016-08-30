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
	
	@ApiModelProperty(value="点赞数量")
	private long praiseNum;
	
	@ApiModelProperty(value="点赞标识")
	private boolean praiseFlag;

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

	public long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public boolean isPraiseFlag() {
		return praiseFlag;
	}

	public void setPraiseFlag(boolean praiseFlag) {
		this.praiseFlag = praiseFlag;
	}

}
