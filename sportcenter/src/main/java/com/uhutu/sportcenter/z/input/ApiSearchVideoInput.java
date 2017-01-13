package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 短视频搜索输入
 * @author 逄小帅
 *
 */
public class ApiSearchVideoInput extends RootApiInput {
	
	@ApiModelProperty(value="短视频标题")
	private String title;
	
	@ApiModelProperty(name = "页码", value = "页码", example = "0")
	private int pagination = 0;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
