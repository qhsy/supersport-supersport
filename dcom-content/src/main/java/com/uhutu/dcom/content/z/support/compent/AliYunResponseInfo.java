package com.uhutu.dcom.content.z.support.compent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 阿里云视频信息
 * 
 * @author
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AliYunResponseInfo {

	private String RequestId;

	private AliYunResponseMediaListInfo MediaList;

	public String getRequestId() {
		return RequestId;
	}

	public void setRequestId(String requestId) {
		RequestId = requestId;
	}

	public AliYunResponseMediaListInfo getMediaList() {
		return MediaList;
	}

	public void setMediaList(AliYunResponseMediaListInfo mediaList) {
		MediaList = mediaList;
	}

}
