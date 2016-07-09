package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 获取微信sdk录音文件
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiSaveWechatVoiceResult extends RootApiResult {

	@ApiModelProperty(value = "服务器语音地址")
	private String voiceUrl = "";

	public String getVoiceUrl() {
		return voiceUrl;
	}

	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}

}
