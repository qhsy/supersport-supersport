package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.ApiAttendInfo;
import com.uhutu.zoocom.root.RootApiResult;
import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户关注列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAttendListResult extends RootApiResult {
	
	@ApiModelProperty(value="用户关注列表")
	private List<ApiAttendInfo> attendList = new ArrayList<ApiAttendInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<ApiAttendInfo> getAttendList() {
		return attendList;
	}

	public void setAttendList(List<ApiAttendInfo> attendList) {
		this.attendList = attendList;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
