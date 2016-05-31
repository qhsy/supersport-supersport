package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.ApiAttendInfo;
import com.uhutu.zoocom.root.RootApiResult;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户粉丝列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiFansListResult extends RootApiResult {
	
	@ApiModelProperty(value="用户粉丝列表")
	private List<ApiAttendInfo> fansList = new ArrayList<ApiAttendInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<ApiAttendInfo> getFansList() {
		return fansList;
	}

	public void setFansList(List<ApiAttendInfo> fansList) {
		this.fansList = fansList;
	}

}
