package com.uhutu.dcom.content.z.support.compent;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 阿里云视频信息
 * 
 * @author
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AliYunResponseMediaListInfo {

	private List<AliYunResponseMediaInfo> Media = new ArrayList<AliYunResponseMediaInfo>();

	public List<AliYunResponseMediaInfo> getMedia() {
		return Media;
	}

	public void setMedia(List<AliYunResponseMediaInfo> media) {
		Media = media;
	}
	
}
