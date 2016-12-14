package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.RedPackInfo;
import com.uhutu.sportcenter.z.entity.RedPackUserInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 红包信息列表
 * @author 逄小帅
 *
 */
public class ApiRedPackInfoListResult extends RootApiResult {
	
	@ApiModelProperty(value = "打赏人员列表")
	private List<RedPackUserInfo> redPackUsers = new ArrayList<RedPackUserInfo>();
	
	@ApiModelProperty(value = "红包列表")
	private List<RedPackInfo> redPackInfos = new ArrayList<RedPackInfo>();

	public List<RedPackUserInfo> getRedPackUsers() {
		return redPackUsers;
	}

	public void setRedPackUsers(List<RedPackUserInfo> redPackUsers) {
		this.redPackUsers = redPackUsers;
	}

	public List<RedPackInfo> getRedPackInfos() {
		return redPackInfos;
	}

	public void setRedPackInfos(List<RedPackInfo> redPackInfos) {
		this.redPackInfos = redPackInfos;
	}
	
}
