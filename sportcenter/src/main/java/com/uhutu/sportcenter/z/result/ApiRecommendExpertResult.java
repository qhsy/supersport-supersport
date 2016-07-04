package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiRecommendExpertResult extends RootApiResult {

	@ApiModelProperty(name = "展示实体数组", notes = "展示实体数组", example = "01")
	private List<UserBasicInfo> list = new ArrayList<UserBasicInfo>();

	public List<UserBasicInfo> getList() {
		return list;
	}

	public void setList(List<UserBasicInfo> list) {
		this.list = list;
	}

}
