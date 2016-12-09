package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveMsgResult extends RootApiResult {
	@ApiModelProperty(value = "直播时间", notes = "直播时间")
	private String createTime;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
