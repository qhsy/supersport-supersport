package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.search.z.entity.SeKeyWordRecomm;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 推荐列表
 * 
 *
 */
@ApiModel
public class ApiKeyWordRecommResult extends RootApiResult {

	@ApiModelProperty(value = "推荐列表")
	private List<SeKeyWordRecomm> labels = new ArrayList<SeKeyWordRecomm>();

	public List<SeKeyWordRecomm> getLabels() {
		return labels;
	}

	public void setLabels(List<SeKeyWordRecomm> labels) {
		this.labels = labels;
	}

}
