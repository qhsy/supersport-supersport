package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 开始直播处理结果
 * @author 逄小帅
 *
 */
public class ApiBeginLiveResult extends RootApiResult {

	@ApiModelProperty(value = "文章编号")
	private String contentCode;
	
	@ApiModelProperty(value = "推流地址")
	private String pushUrl;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getPushUrl() {
		return pushUrl;
	}

	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	
}
