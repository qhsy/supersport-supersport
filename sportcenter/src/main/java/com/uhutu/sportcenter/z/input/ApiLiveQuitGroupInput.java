package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播退出聊天室
 * @author 逄小帅
 *
 */
public class ApiLiveQuitGroupInput extends RootApiInput {

	@ApiModelProperty(value="0:直播 1:主播")
	private int flag;
	
	@ApiModelProperty(value="主播用户标识")
	private String userCode;
	
	@ApiModelProperty(value="flag为0情况下填群组id，为1情况下填fileid")
	private String groupId;

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

}
