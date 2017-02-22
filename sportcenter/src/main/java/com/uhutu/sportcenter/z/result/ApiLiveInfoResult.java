package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.content.z.entity.CnLiveVideoDetail;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveInfoResult extends RootApiResult {
	
	@ApiModelProperty(value = "直播所需参数", notes = "直播所需参数")
	private CnLiveVideoDetail detail = new CnLiveVideoDetail();
	
	@ApiModelProperty(value="直播类型 0:直播 1:点播")
	private int liveType;
	
	@ApiModelProperty(value="是否开启打赏")
	private boolean redPackFalg = false;

	@ApiModelProperty(value = "直播appId", notes = "直播appId")
	private String appId;

	@ApiModelProperty(value = "主播基本信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();
	
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

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public int getLiveType() {
		return liveType;
	}

	public void setLiveType(int liveType) {
		this.liveType = liveType;
	}

	public boolean isRedPackFalg() {
		return redPackFalg;
	}

	public void setRedPackFalg(boolean redPackFalg) {
		this.redPackFalg = redPackFalg;
	}

}
