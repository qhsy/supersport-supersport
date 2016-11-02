package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.user.z.page.vo.UcUserinfoExtData;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知列表
 * 
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUserDataExpertResult extends RootApiResult {

	@ApiModelProperty(value = "用户列表")
	private List<UcUserinfoExtData> users = new ArrayList<UcUserinfoExtData>();

	@ApiModelProperty(value = "用户列表MJ")
	private List<UcUserinfoExtData> mjUsers = new ArrayList<UcUserinfoExtData>();

	public List<UcUserinfoExtData> getUsers() {
		return users;
	}

	public void setUsers(List<UcUserinfoExtData> users) {
		this.users = users;
	}

	public List<UcUserinfoExtData> getMjUsers() {
		return mjUsers;
	}

	public void setMjUsers(List<UcUserinfoExtData> mjUsers) {
		this.mjUsers = mjUsers;
	}

}
