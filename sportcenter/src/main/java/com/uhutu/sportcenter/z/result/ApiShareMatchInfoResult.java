package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.sportcenter.z.entity.MatchSignInfo;
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
	
	@ApiModelProperty(value="赛事报名信息")
	private MatchSignInfo matchSignInfo = new MatchSignInfo();
	
	@ApiModelProperty(value="报名链接")
	private String signUrl = "";

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
	

}
