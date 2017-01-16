package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 邀请用户操作
 * @author 逄小帅
 *
 */
public class ApiOperInviteUserInput extends RootApiInput {
	
	@ApiModelProperty(value="用户头像",required = true)
	private String headUrl;
	
	@ApiModelProperty(value="用户昵称",required = true)
	private String nickName;

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
