package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 输入参数信息
 * @author 逄小帅
 *
 */
public class ApiAttendFlagInput extends RootApiInput {
	
	@ApiModelProperty(value="被关注的用户编号")
	private String beAttend;

	public String getBeAttend() {
		return beAttend;
	}

	public void setBeAttend(String beAttend) {
		this.beAttend = beAttend;
	}

}
