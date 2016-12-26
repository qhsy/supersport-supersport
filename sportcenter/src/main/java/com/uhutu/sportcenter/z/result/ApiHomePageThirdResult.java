package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.HomePageThird;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiHomePageThirdResult extends RootApiResult {

	@ApiModelProperty(value = "首页展示实体数组", notes = "首页展示实体数组", example = "01")
	private List<HomePageThird> list = new ArrayList<HomePageThird>();

	public List<HomePageThird> getList() {
		return list;
	}

	public void setList(List<HomePageThird> list) {
		this.list = list;
	}

}
