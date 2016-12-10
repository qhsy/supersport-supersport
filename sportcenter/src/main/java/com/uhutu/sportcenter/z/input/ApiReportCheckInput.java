package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiReportCheckInput extends RootApiInput {

	@ApiModelProperty(name = "活动编号", value = "活动编号", example = "活动编号", required = true)
	private String reportCode = "";

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

}
