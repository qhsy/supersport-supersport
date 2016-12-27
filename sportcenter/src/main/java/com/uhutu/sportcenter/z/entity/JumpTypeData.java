package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 跳转参数
 * 
 * @author xiegj
 *
 */
public class JumpTypeData {

	@ApiModelProperty(name = "跳转类型", notes = "dzsd4107100110150001:内容详情,dzsd4107100110150002:个人主页,"
			+ "dzsd4107100110150003:URL,dzsd4107100110150004:标签详情,dzsd4107100110150005:赛事详情", example = "01")
	private String jumpType;

	@ApiModelProperty(name = "跳转内容", notes = "轮播图链接跳转内容", example = "http://www.ichsy.com")
	private String jumpContent;

	@ApiModelProperty(name = "跳转后标题", notes = "跳转后标题", example = "http://www.ichsy.com")
	private String jumpTitle;

	@ApiModelProperty(name = "文章类型", notes = "dzsd4107100110030001:文章 ,dzsd4107100110030002:文章(含视频),dzsd4107100110030003:图集,dzsd4107100110030004:单图,dzsd4107100110030005:单视频", example = "dzsd4107100110030001")
	private String contentType;

	@ApiModelProperty(value = "第三方链接", notes = "第三方链接")
	private String url;

	public String getJumpType() {
		return jumpType;
	}

	public void setJumpType(String jumpType) {
		this.jumpType = jumpType;
	}

	public String getJumpContent() {
		return jumpContent;
	}

	public void setJumpContent(String jumpContent) {
		this.jumpContent = jumpContent;
	}

	public String getJumpTitle() {
		return jumpTitle;
	}

	public void setJumpTitle(String jumpTitle) {
		this.jumpTitle = jumpTitle;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
