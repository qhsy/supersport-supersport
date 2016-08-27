package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.PaCoinFlowInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金币流水信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiCoinFlowInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="流水信息列表")
	private List<PaCoinFlowInfo> coinFlowInfos = new ArrayList<PaCoinFlowInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<PaCoinFlowInfo> getCoinFlowInfos() {
		return coinFlowInfos;
	}

	public void setCoinFlowInfos(List<PaCoinFlowInfo> coinFlowInfos) {
		this.coinFlowInfos = coinFlowInfos;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
