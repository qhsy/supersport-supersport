package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiReportSaveInput extends RootApiInput {

	@ApiModelProperty(value = "信息来源来源 dzsd4112100110020001:app,dzsd4112100110020002:H5", example = "dzsd4112100110020002", required = true)
	private String orderSource;
	
	@ApiModelProperty(name = "活动编号", value = "活动编号", example = "活动编号", required = true)
	private String reportCode = "";

	@ApiModelProperty(name = "活动信息", value = "活动信息", example = "活动信息", required = true)
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

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

}
