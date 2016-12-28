package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事结果
 * @author 逄小帅
 *
 */
public class ApiShareMatchInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="赛事信息")
	private MatchInfo matchInfo = new MatchInfo();
	
	@ApiModelProperty(value="报名链接")
	private String signUrl = "";
	
	@ApiModelProperty(value="是否直接报名")
	private boolean redirectFlag = false;

	public MatchInfo getMatchInfo() {
		return matchInfo;
	}

	public void setMatchInfo(MatchInfo matchInfo) {
		this.matchInfo = matchInfo;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public boolean isRedirectFlag() {
		return redirectFlag;
	}

	public void setRedirectFlag(boolean redirectFlag) {
		this.redirectFlag = redirectFlag;
	}
	

}
