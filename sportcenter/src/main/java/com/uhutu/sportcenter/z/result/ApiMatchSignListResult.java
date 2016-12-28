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
	
	@ApiModelProperty(value="赛事编号")
	private String matchCode;
	
	@ApiModelProperty(value="赛事名称")
	private String matchName;
	
	@ApiModelProperty(value="赛事报名信息列表")
	private List<MatchSignInfo> matchSignInfos = new ArrayList<MatchSignInfo>();	

	public List<MatchSignInfo> getMatchSignInfos() {
		return matchSignInfos;
	}

	public void setMatchSignInfos(List<MatchSignInfo> matchSignInfos) {
		this.matchSignInfos = matchSignInfos;
	}

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getMatchName() {
		return matchName;
	}

	public void setMatchName(String matchName) {
		this.matchName = matchName;
	}

}
