package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容展示模型
 * @author 逄小帅
 *
 */
public class ContentShowModel {

	@ApiModelProperty(value="用户基本信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();
	
	@ApiModelProperty(value="内容展示信息")
	private ContentShowInfo contentShowInfo = new ContentShowInfo();

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public ContentShowInfo getContentShowInfo() {
		return contentShowInfo;
	}

	public void setContentShowInfo(ContentShowInfo contentShowInfo) {
		this.contentShowInfo = contentShowInfo;
	}
	
}
