package com.uhutu.dcom.extend.baiduPush.model;

public class QueryStatisticDeviceRequest extends PushRequest{

    public QueryStatisticDeviceRequest addDeviceType (Integer deviceType) {
    	this.deviceType = deviceType;
    	return this;
    }
	public QueryStatisticDeviceRequest addExpires(Long requestTimeOut) {
		this.expires = requestTimeOut;
		return this;
	}
}
