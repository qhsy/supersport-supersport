package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.UserInfo;
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

	@ApiModelProperty(name = "是否关注",notes="如果获取的用户信息不是自己，则使用本参数,1:已关注，0:未关注", example = "0")
	private String flag = "";	
	
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
