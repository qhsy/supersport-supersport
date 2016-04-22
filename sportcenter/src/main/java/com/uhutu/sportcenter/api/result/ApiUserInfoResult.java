package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.api.entity.UserInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息展示列表
 * @author pang_jhui
 *
 */
public class ApiUserInfoResult extends RootApiResult {
	
	@ApiModelProperty(value = "用户信息")
	private UserInfo userInfo = new UserInfo();

	@ApiModelProperty(value = "运动时刻信息")
	private List<ContentBasicinfoForApi> moments = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<ContentBasicinfoForApi> getMoments() {
		return moments;
	}

	public void setMoments(List<ContentBasicinfoForApi> moments) {
		this.moments = moments;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	
}
