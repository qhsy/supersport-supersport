package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.dcom.content.z.entity.CnRedPackInfo;
import com.uhutu.dcom.content.z.entity.CnRedPackUser;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 红包信息列表
 * @author 逄小帅
 *
 */
public class ApiRedPackInfoListResult extends RootApiResult {
	
	@ApiModelProperty(value = "打赏人员列表")
	private List<CnRedPackUser> redPackUsers = new ArrayList<CnRedPackUser>();
	
	@ApiModelProperty(value = "红包列表")
	private List<CnRedPackInfo> redPackInfos = new ArrayList<CnRedPackInfo>();

	public List<CnRedPackUser> getRedPackUsers() {
		return redPackUsers;
	}

	public void setRedPackUsers(List<CnRedPackUser> redPackUsers) {
		this.redPackUsers = redPackUsers;
	}

	public List<CnRedPackInfo> getRedPackInfos() {
		return redPackInfos;
	}

	public void setRedPackInfos(List<CnRedPackInfo> redPackInfos) {
		this.redPackInfos = redPackInfos;
	}
	
}
