package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提问
 *
 */
@ApiModel
public class ApiForAskQuestionResult extends RootApiResult {

	@ApiModelProperty(value = "问达编号", notes = "问达编号", required = true, example = "MeiZi666")
	private String code = "";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
