package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.extend.z.entity.ReReportInfo;
import com.uhutu.sportcenter.z.entity.ReReportFieldForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiReportFieldsResult extends RootApiResult {

	@ApiModelProperty(name = "报表信息")
	private ReReportInfo fs = new ReReportInfo();

	@ApiModelProperty(name = "报表字段参数信息")
	List<ReReportFieldForApi> fields = new ArrayList<ReReportFieldForApi>();

	@ApiModelProperty(name = "按钮信息")
	List<ReReportFieldForApi> buttons = new ArrayList<ReReportFieldForApi>();

	public ReReportInfo getFs() {
		return fs;
	}

	public void setFs(ReReportInfo fs) {
		this.fs = fs;
	}

	public List<ReReportFieldForApi> getFields() {
		return fields;
	}

	public void setFields(List<ReReportFieldForApi> fields) {
		this.fields = fields;
	}

	public List<ReReportFieldForApi> getButtons() {
		return buttons;
	}

	public void setButtons(List<ReReportFieldForApi> buttons) {
		this.buttons = buttons;
	}

}
