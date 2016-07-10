package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 语音播放
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiPlayAudioResult extends RootApiResult {
	
	@ApiModelProperty(value="微信语音mediaId")
	private String mediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
	

}
