package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户能量初始化input
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUserPowerInitInput extends RootApiInput {
	
	@ApiModelProperty(value="设备编号")
	private String deviceId;
	
	@ApiModelProperty(value="最新的能量值")
	private long currPower;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public long getCurrPower() {
		return currPower;
	}

	public void setCurrPower(long currPower) {
		this.currPower = currPower;
	}



}
