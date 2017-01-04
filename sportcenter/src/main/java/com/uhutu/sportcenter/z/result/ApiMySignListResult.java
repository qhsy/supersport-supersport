package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.MySignInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 我的报名信息结果
 * @author 逄小帅
 *
 */
public class ApiMySignListResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	@ApiModelProperty(value="报名信息列表")
	private List<MySignInfo> mySignInfos = new ArrayList<MySignInfo>();

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<MySignInfo> getMySignInfos() {
		return mySignInfos;
	}

	public void setMySignInfos(List<MySignInfo> mySignInfos) {
		this.mySignInfos = mySignInfos;
	}

}
