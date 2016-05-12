package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论列表信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRemarkListInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="内容编号")
	private String contentCode;
	
	@ApiModelProperty(value="页码",example="从1开始")
	private int pagination = 1;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}
	
	

}
