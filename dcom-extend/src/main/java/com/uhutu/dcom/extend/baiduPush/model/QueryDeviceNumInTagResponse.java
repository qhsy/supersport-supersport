package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class QueryDeviceNumInTagResponse extends PushResponse{

	@JSonPath(path="response_params\\device_num")
	private int deviceNum;
	
	// get
	public int getDeviceNum () {
		return deviceNum;
	}
}
