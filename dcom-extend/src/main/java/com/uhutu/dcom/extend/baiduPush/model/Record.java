package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.constants.BaiduPushConstants;
import com.uhutu.dcom.extend.baiduPush.core.annotation.HttpParamKeyName;
import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;
import com.uhutu.dcom.extend.baiduPush.core.annotation.R;
import com.uhutu.dcom.extend.baiduPush.core.annotation.RangeRestrict;

public class Record {

	@JSonPath(path="msg_id")
	@HttpParamKeyName(name=BaiduPushConstants.MSG_ID, param=R.REQUIRE)
	private String msgId = null;
	
	@JSonPath(path="status")
	@HttpParamKeyName(name=BaiduPushConstants.MSG_STATUS, param=R.REQUIRE)
	@RangeRestrict(minLength=0, maxLength=3)
	private Integer status = null;
	
	@JSonPath(path="send_time")
	@HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.REQUIRE)
	private long sendTime;
	
	// get
	public String getMsgId () {
		return msgId;
	}
	public Integer getMsgStatus () {
		return status;
	}
	public long getSendTime () {
		return sendTime;
	}
}
