package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 地址转转
 * @author 逄小帅
 *
 */
public class ApiConvertStreamUrlResult extends RootApiResult {
	
	@ApiModelProperty(value="拉流地址")
	private String playUrl = "";
	
	@ApiModelProperty(value="推流地址")
	private String pushUrl = "";

	public String getPlayUrl() {
		return playUrl;
	}

	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
	}

	public String getPushUrl() {
		return pushUrl;
	}

	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}

	

}
