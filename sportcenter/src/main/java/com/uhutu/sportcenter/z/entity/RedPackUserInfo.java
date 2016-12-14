package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 人员打赏金额信息
 * 
 * @author 逄小帅
 *
 */
public class RedPackUserInfo extends UserBasicInfo {

	@ApiModelProperty(name = "直播号")
	private String busiCode;

	@ApiModelProperty(name = "打赏人员用户编号")
	private String userCode;
	
	@ApiModelProperty(name = "排序")
	private int sort;

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}


}
