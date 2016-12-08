package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiReportSaveInput extends RootApiInput {

	@ApiModelProperty(name = "活动编号", value = "活动编号", example = "活动编号")
	private String reportCode = "";

	@ApiModelProperty(name = "活动信息", value = "活动信息", example = "活动信息")
	private MDataMap map = new MDataMap();

	public String getReportCode() {
		return reportCode;
	}

	public void setReportCode(String reportCode) {
		this.reportCode = reportCode;
	}

	public MDataMap getMap() {
		return map;
	}

	public void setMap(MDataMap map) {
		this.map = map;
	}

}
