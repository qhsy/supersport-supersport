package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.MatchInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事信息列表信息
 * @author 逄小帅
 *
 */
public class ApiMacthInfoListResult extends RootApiResult {
	
	@ApiModelProperty(value="赛事信息列表")
	private List<MatchInfo> matchInfos = new ArrayList<MatchInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<MatchInfo> getMatchInfos() {
		return matchInfos;
	}

	public void setMatchInfos(List<MatchInfo> matchInfos) {
		this.matchInfos = matchInfos;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
