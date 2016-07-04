package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiRecommendExpertInput extends RootApiInput {

	@ApiModelProperty(value = "展示的第几页数据(第一页开始)", notes = "展示的第几天数据", example = "1", required = true)
	private int pagination = 1;

	@ApiModelProperty(value = "每页展示个数", notes = "每页展示个数", example = "10", required = true)
	private int num = 1;
	
	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
