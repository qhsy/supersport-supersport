package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.api.entity.HomePageModel;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiHomePageResult extends RootApiResult {
	
	@ApiModelProperty(name="首页展示实体数组" ,notes="首页展示实体数组",example="01")
	private List<HomePageModel>	list=	new  ArrayList<HomePageModel>();

	public List<HomePageModel> getList() {
		return list;
	}

	public void setList(List<HomePageModel> list) {
		this.list = list;
	}

}
