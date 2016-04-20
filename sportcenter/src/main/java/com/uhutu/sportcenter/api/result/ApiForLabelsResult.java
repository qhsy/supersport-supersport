package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.tag.entity.Label;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForLabelsResult extends RootApiResult {

	@ApiModelProperty(name="运动标签" ,notes="标签")
	private List<Label> labels = new ArrayList<Label>();

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
	
}
