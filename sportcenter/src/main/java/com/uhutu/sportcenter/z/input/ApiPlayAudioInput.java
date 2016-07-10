package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 音频播放接口
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiPlayAudioInput extends RootApiInput {
	
	@ApiModelProperty(value="语音路径")
	private String audioUrl;
	
	@ApiModelProperty(value="问题编号")
	private String questionCode;

	public String getAudioUrl() {
		return audioUrl;
	}

	public void setAudioUrl(String audioUrl) {
		this.audioUrl = audioUrl;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}
	
	

}
