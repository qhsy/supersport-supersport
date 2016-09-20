package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.HomePageSecond;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiHomePageSecondResult extends RootApiResult {

	@ApiModelProperty(value = "首页展示实体数组", notes = "首页展示实体数组", example = "01")
	private List<HomePageSecond> list = new ArrayList<HomePageSecond>();

	public List<HomePageSecond> getList() {
		return list;
	}

	public void setList(List<HomePageSecond> list) {
		this.list = list;
	}

}
