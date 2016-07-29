package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.RecommExpertInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiRecommendExpertResult extends RootApiResult {

	@ApiModelProperty(name = "展示实体数组", notes = "展示实体数组", example = "01")
	private List<RecommExpertInfo> list = new ArrayList<RecommExpertInfo>();

	public List<RecommExpertInfo> getList() {
		return list;
	}

	public void setList(List<RecommExpertInfo> list) {
		this.list = list;
	}

}
