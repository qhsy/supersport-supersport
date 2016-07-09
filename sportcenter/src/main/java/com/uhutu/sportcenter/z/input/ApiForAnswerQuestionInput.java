package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回答信息
 *
 */
public class ApiForAnswerQuestionInput extends RootApiInput {
	@ApiModelProperty(value = "问题编号")
	private String code;

	@ApiModelProperty(value = "语音路径")
	private String url;

	@ApiModelProperty(value = "微信录音文件编号", required = true)
	private String wechatVoiceId = "";
	
	@ApiModelProperty(value = "语音长度(秒)")
	private int lengh;

	@ApiModelProperty(value = "拒绝回答", notes = "true:拒绝回答,false:回答")
	private boolean refuse;

	public String getWechatVoiceId() {
		return wechatVoiceId;
	}

	public void setWechatVoiceId(String wechatVoiceId) {
		this.wechatVoiceId = wechatVoiceId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLengh() {
		return lengh;
	}

	public void setLengh(int lengh) {
		this.lengh = lengh;
	}

	public boolean isRefuse() {
		return refuse;
	}

	public void setRefuse(boolean refuse) {
		this.refuse = refuse;
	}

}