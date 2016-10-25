package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容图集处理结果
 * @author pang_jhui
 *
 */
public class ApiPublishContentPhotosResult extends RootApiResult {
	
	@ApiModelProperty(value = "编号", notes = "编号")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
