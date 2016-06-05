package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 达人用户信息
 * @author pang_jhui
 *
 */
public class UserInfoExpert {
	
	@ApiModelProperty(value="用户编号")
	private String userCode;
	
	@ApiModelProperty(value="真实姓名")
	private String realName;
	
	@ApiModelProperty(value="签名图片")
	private String signPic;
	
	@ApiModelProperty(value="封面图片",notes="达人头像")
	private String coverPic;
	
	@ApiModelProperty(value="宣传图片",notes="详情页宣传图片")
	private String advPic;
	
	@ApiModelProperty(value="排名图片")
	private String sortPic;
	
	@ApiModelProperty(value="能量值")
	private long power;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}

	public String getCoverPic() {
		return coverPic;
	}

	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}

	public String getAdvPic() {
		return advPic;
	}

	public void setAdvPic(String advPic) {
		this.advPic = advPic;
	}

	public long getPower() {
		return power;
	}

	public void setPower(long power) {
		this.power = power;
	}

	public String getSortPic() {
		return sortPic;
	}

	public void setSortPic(String sortPic) {
		this.sortPic = sortPic;
	} 
	
	

}
