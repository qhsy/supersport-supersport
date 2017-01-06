package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 关注结果
 * @author 逄小帅
 *
 */
public class ApiAttendFlagResult extends RootApiResult {
	
	@ApiModelProperty(value="关注标识")
	private boolean attendFlag = false;

	public boolean isAttendFlag() {
		return attendFlag;
	}

	public void setAttendFlag(boolean attendFlag) {
		this.attendFlag = attendFlag;
	}

}
