package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.MatchSignInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事报名列表信息
 * @author 逄小帅
 *
 */
public class ApiMatchSignListResult extends RootApiResult {
	
	@ApiModelProperty(value="赛事报名信息列表")
	private List<MatchSignInfo> matchSignInfos = new ArrayList<MatchSignInfo>();
	
	@ApiModelProperty(value="跳转标识")
	private boolean redirectFlag = false;

	public List<MatchSignInfo> getMatchSignInfos() {
		return matchSignInfos;
	}

	public void setMatchSignInfos(List<MatchSignInfo> matchSignInfos) {
		this.matchSignInfos = matchSignInfos;
	}

	public boolean isRedirectFlag() {
		return redirectFlag;
	}

	public void setRedirectFlag(boolean redirectFlag) {
		this.redirectFlag = redirectFlag;
	}

}
