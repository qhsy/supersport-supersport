package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.LiveDetailInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;
/**
 * 直播信息列表
 * @author 逄小帅
 *
 */
public class ApiLiveInfoListResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	@ApiModelProperty(name="直播信息列表",value="直播信息列表",example="")
	private List<LiveDetailInfo>  liveDetailInfos  	=	new ArrayList<LiveDetailInfo>();

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<LiveDetailInfo> getLiveDetailInfos() {
		return liveDetailInfos;
	}

	public void setLiveDetailInfos(List<LiveDetailInfo> liveDetailInfos) {
		this.liveDetailInfos = liveDetailInfos;
	}

}
