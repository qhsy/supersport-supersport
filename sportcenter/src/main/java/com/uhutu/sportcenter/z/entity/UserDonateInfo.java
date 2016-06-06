package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户捐赠信息
 * @author 逄小帅
 *
 */
public class UserDonateInfo extends UserBasicInfo {
	
	@ApiModelProperty(value="支持总能量值")
	private long totalPower;
	
	@ApiModelProperty(value="格式化能量值")
	private String totalPowerStr;

	public long getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(long totalPower) {
		this.totalPower = totalPower;
	}

	public String getTotalPowerStr() {
		return totalPowerStr;
	}

	public void setTotalPowerStr(String totalPowerStr) {
		this.totalPowerStr = totalPowerStr;
	}
	
	

}
