package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.CnLiveInfo;
import com.uhutu.dcom.content.z.entity.CnLiveMatchInfo;
import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectForApi;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveInfoResult extends RootApiResult {

	@ApiModelProperty(value = "直播信息", notes = "直播信息")
	private CnLiveInfo liveInfo = new CnLiveInfo();

	@ApiModelProperty(value = "主播基本信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();

	@ApiModelProperty(value = "球队信息")
	List<CnLiveMatchInfo> matchs = new ArrayList<CnLiveMatchInfo>();

	@ApiModelProperty(value = "特效信息")
	List<CnLiveSpecialEffectForApi> lse = new ArrayList<CnLiveSpecialEffectForApi>();

	public CnLiveInfo getLiveInfo() {
		return liveInfo;
	}

	public void setLiveInfo(CnLiveInfo liveInfo) {
		this.liveInfo = liveInfo;
	}

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public List<CnLiveMatchInfo> getMatchs() {
		return matchs;
	}

	public void setMatchs(List<CnLiveMatchInfo> matchs) {
		this.matchs = matchs;
	}

	public List<CnLiveSpecialEffectForApi> getLse() {
		return lse;
	}

	public void setLse(List<CnLiveSpecialEffectForApi> lse) {
		this.lse = lse;
	}
	
}
