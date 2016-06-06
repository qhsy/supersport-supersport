package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 达人用户信息详情
 * @author 逄小帅
 *
 */
public class UserInfoExpertDetail extends UserInfoExpert {
	
	@ApiModelProperty(value="运动经历")
	private String experience;
	
	@ApiModelProperty(value="排名")
	private int sort;

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
