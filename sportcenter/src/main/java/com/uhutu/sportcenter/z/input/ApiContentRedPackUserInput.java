package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容打赏用户列表
 * @author 逄小帅
 *
 */
public class ApiContentRedPackUserInput extends RootApiInput {
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="内容编号")
	private String contentCode;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
