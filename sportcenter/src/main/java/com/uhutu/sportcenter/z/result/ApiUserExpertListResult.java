package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.UserInfoExpert;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 达人用户列表result
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUserExpertListResult extends RootApiResult {
	
	@ApiModelProperty(value="达人用户列表")
	private List<UserInfoExpert> userInfoExperts = new ArrayList<UserInfoExpert>();
	
	@ApiModelProperty(value="可用能量值",notes="当前用户可用能量值")
	private long freePower;

	public List<UserInfoExpert> getUserInfoExperts() {
		return userInfoExperts;
	}

	public void setUserInfoExperts(List<UserInfoExpert> userInfoExperts) {
		this.userInfoExperts = userInfoExperts;
	}

	public long getFreePower() {
		return freePower;
	}

	public void setFreePower(long freePower) {
		this.freePower = freePower;
	}
	
	

}
