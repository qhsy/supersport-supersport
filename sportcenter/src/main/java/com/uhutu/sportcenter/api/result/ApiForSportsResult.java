package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.api.entity.ContentSportForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForSportsResult extends RootApiResult {

	@ApiModelProperty(name = "运动实体", notes = "运动实体")
	private List<ContentSportForApi> sports = new ArrayList<ContentSportForApi>();

	public List<ContentSportForApi> getSports() {
		return sports;
	}

	public void setSports(List<ContentSportForApi> sports) {
		this.sports = sports;
	}

}
