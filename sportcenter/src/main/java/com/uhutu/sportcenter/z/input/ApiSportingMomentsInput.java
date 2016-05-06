package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiSportingMomentsInput extends RootApiInput {

	@ApiModelProperty(name="页码",value="页码",example="0")
	private int  pagination= 0;

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}
	
}
