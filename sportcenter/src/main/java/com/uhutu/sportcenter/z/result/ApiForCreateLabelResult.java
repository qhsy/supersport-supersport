package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.Label;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForCreateLabelResult extends RootApiResult {
	@ApiModelProperty(value = "运动标签", notes = "标签")
	private Label label = new Label();

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}
