package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class KeyValueForAck {

	@JSonPath(path="key")
	private String timestamp;
	
	@JSonPath(path="value")
	private int value;
	
	public void setKey (String key) {
		this.timestamp = key;
	}
	
	public void setValue (int value) {
		this.value = value;
	}
	
	public String getKey () {
		return timestamp;
	}
	public int getValue () {
		return value;
	}
}
