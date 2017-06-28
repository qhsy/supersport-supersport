package com.uhutu.dcom.content.z.support.compent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 阿里云视频信息
 * 
 * @author
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AliYunResponseMediaInfo {

	private String CoverURL;

	private String PublishState;

	private String Height;

	private String MediaId;

	private String Duration;

	public String getCoverURL() {
		return CoverURL;
	}

	public void setCoverURL(String coverURL) {
		CoverURL = coverURL;
	}

	public String getPublishState() {
		return PublishState;
	}

	public void setPublishState(String publishState) {
		PublishState = publishState;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}
}
