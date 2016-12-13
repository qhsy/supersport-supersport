package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 红包信息列表
 * @author 逄小帅
 *
 */
public class ApiRedPackInfoListInput extends RootApiInput {
	
	@ApiModelProperty(value = "直播编号")
	private String liveCode;

	public String getLiveCode() {
		return liveCode;
	}

	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}

	

}
