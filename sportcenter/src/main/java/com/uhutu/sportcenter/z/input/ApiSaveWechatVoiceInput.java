package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 获取微信sdk录音文件
 * 
 * @author xiegj
 *
 */
public class ApiSaveWechatVoiceInput extends RootApiInput {

	@ApiModelProperty(value = "微信录音文件编号", required = true)
	private String wechatVoiceId = "";

	public String getWechatVoiceId() {
		return wechatVoiceId;
	}

	public void setWechatVoiceId(String wechatVoiceId) {
		this.wechatVoiceId = wechatVoiceId;
	}

}
