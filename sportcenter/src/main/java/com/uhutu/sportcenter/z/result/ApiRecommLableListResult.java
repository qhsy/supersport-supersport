package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.Label;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 推荐标签列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRecommLableListResult extends RootApiResult {
	
	@ApiModelProperty(value="推荐标签列表")
	private List<Label> labels = new ArrayList<Label>();

	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

}
