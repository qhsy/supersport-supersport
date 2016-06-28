package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class TagInfo {

	@JSonPath(path="tid")
	private String tagId;
	
	@JSonPath(path="tag")
	private String tagName = null;
	
	@JSonPath(path="info")
	private String info = null;
	
	@JSonPath(path="type")
	private int type;
	
	@JSonPath(path="create_time")
	private long createTime;

	// get
	public String getTagId() {
		return tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public String getInfo() {
		return info;
	}
	public int getType() {
		return type;
	}
	public long getCreateTime() {
		return createTime;
	}
}
