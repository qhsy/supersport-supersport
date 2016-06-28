package com.uhutu.dcom.extend.baiduPush.model;

import java.util.LinkedList;
import java.util.List;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;

public class AddDevicesToTagResponse extends PushResponse{

	@JSonPath(path="response_params\\result")
	private List<DeviceInfo> devicesInfoAfterAdded = new LinkedList<DeviceInfo> ();
	
	// get
	public List<DeviceInfo> getDevicesInfoAfterAdded () {
		return devicesInfoAfterAdded;
	}
}
