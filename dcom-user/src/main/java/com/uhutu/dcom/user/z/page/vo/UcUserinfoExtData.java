package com.uhutu.dcom.user.z.page.vo;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息扩展
 * 
 * @author xiegj
 *
 */
public class UcUserinfoExtData extends BaseEntity {

	private String userCode;

	@ApiModelProperty(name = "昵称", notes = "昵称", example = "papi酱")
	private String nickName;

	@ApiModelProperty(name = "头像", notes = "头像", example = "头像")
	private String aboutHead;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAboutHead() {
		return aboutHead;
	}

	public void setAboutHead(String aboutHead) {
		this.aboutHead = aboutHead;
	}

}
