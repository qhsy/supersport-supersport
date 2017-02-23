package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 地址转换
 * @author 逄小帅
 *
 */
public class ApiConvertStreamUrlInput extends RootApiInput {
	
	@ApiModelProperty(value="流地址")
	private String streamUrl = "";
	
	@ApiModelProperty(value="1:大主播拉流地址  2:小主播推拉流地址 ")
	private int operType;

	public String getStreamUrl() {
		return streamUrl;
	}

	public void setStreamUrl(String streamUrl) {
		this.streamUrl = streamUrl;
	}

	public int getOperType() {
		return operType;
	}

	public void setOperType(int operType) {
		this.operType = operType;
	}

}
