package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.api.entity.SportCategoryForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForSportsResult extends RootApiResult {

	@ApiModelProperty(name = "运动实体", notes = "运动实体")
	private List<SportCategoryForApi> sports = new ArrayList<SportCategoryForApi>();

	public List<SportCategoryForApi> getSports() {
		return sports;
	}

	public void setSports(List<SportCategoryForApi> sports) {
		this.sports = sports;
	}

}
