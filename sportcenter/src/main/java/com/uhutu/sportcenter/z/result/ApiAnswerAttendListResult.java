package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ApiAnswerAttendInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户关注列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAnswerAttendListResult extends RootApiResult {
	
	@ApiModelProperty(value="用户关注列表")
	private List<ApiAnswerAttendInfo> attendList = new ArrayList<ApiAnswerAttendInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<ApiAnswerAttendInfo> getAttendList() {
		return attendList;
	}

	public void setAttendList(List<ApiAnswerAttendInfo> attendList) {
		this.attendList = attendList;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
