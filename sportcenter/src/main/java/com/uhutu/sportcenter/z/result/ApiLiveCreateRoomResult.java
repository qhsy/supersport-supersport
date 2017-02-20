package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建房间
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiLiveCreateRoomResult extends RootApiResult {

	@ApiModelProperty(value = "房间编号")
	private String code;
	
	@ApiModelProperty(value="推流URL")
	private String pushUrl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPushUrl() {
		return pushUrl;
	}

	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}

}
