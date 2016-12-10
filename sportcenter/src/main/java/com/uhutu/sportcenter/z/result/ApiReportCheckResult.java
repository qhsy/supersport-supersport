package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiReportCheckResult extends RootApiResult {

	@ApiModelProperty(name = "状态", notes = "状态")
	private boolean flag = false;

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
