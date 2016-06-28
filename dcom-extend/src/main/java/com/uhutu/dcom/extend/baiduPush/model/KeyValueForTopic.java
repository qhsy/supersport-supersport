package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class KeyValueForTopic {

	@JSonPath(path="key")
	private String timestamp;
	
	@JSonPath(path="value")
	private TopicStatUnit value = null;
	
	public void setKey (String key) {
		this.timestamp = key;
	}
	
	public void setValue (TopicStatUnit value) {
		this.value = value;
	}
	// get
	public String getKey () {
		return timestamp;
	}
	public TopicStatUnit getValue () {
		return value;
	}
}
