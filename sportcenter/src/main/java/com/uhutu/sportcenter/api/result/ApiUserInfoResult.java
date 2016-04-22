package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
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
	private List<CnContentBasicinfo> moments = new ArrayList<CnContentBasicinfo>();
	
	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<CnContentBasicinfo> getMoments() {
		return moments;
	}

	public void setMoments(List<CnContentBasicinfo> moments) {
		this.moments = moments;
	}

	
}
