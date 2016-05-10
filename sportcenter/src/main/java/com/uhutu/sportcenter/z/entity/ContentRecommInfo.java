package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 编辑推荐内容详情api
 * @author 逄小帅
 *
 */
public class ContentRecommInfo {
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String contentCode;
	
	@ApiModelProperty(value="编辑推荐内容",notes="编辑推荐内容")
	private String content;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
