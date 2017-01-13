package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.search.z.entity.MatchData;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 搜索赛事结果
 * @author 逄小帅
 *
 */
public class ApiSearchMatchResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= false;
	
	@ApiModelProperty(value="查询数据")
	private List<MatchData> matchDatas = new ArrayList<MatchData>();

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<MatchData> getMatchDatas() {
		return matchDatas;
	}

	public void setMatchDatas(List<MatchData> matchDatas) {
		this.matchDatas = matchDatas;
	}

	
}
