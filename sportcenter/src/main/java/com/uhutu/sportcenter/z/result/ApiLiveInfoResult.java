package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveInfoResult extends RootApiResult {
	@ApiModelProperty(value = "直播所需参数", notes = "直播所需参数")
	private CnLiveVideoDetail detail = new CnLiveVideoDetail();

	@ApiModelProperty(value = "直播appId", notes = "直播appId")
	private String appId;

	public CnLiveVideoDetail getDetail() {
		return detail;
	}

	public void setDetail(CnLiveVideoDetail detail) {
		this.detail = detail;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

}
