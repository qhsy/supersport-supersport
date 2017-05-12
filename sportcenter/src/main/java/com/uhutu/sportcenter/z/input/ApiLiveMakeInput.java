package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveMakeInput extends RootApiInput {

	@ApiModelProperty(name = "内容编号", required = true, value = "内容编号", example = "v1.1.0")
	private String contentCode;

	@ApiModelProperty(name = "预约标志", required = true, value = "预约标志", example = "")
	private boolean makeFlag;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public boolean isMakeFlag() {
		return makeFlag;
	}

	public void setMakeFlag(boolean makeFlag) {
		this.makeFlag = makeFlag;
	}

}
