package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 更新达人能量值
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiUpdateUserPowerInput extends RootApiInput {
	
	@ApiModelProperty(value="达人用户编号")
	private String userCode;
	
	@ApiModelProperty(value="捐赠的能量值")
	private long donatePower;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public long getDonatePower() {
		return donatePower;
	}

	public void setDonatePower(long donatePower) {
		this.donatePower = donatePower;
	}

}
