package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class DeviceInfo {

	@JSonPath(path="channel_id")
	private String channelId = null;
	
	@JSonPath(path="result")
	private int result; // 0 -- successfully delete device from tag, 
	                    // 1 -- fail to delete device from tag
	
	// get
	public String getChannelId () {
		return channelId;
	}
	public int getResult () {
		return result;
	}
}
