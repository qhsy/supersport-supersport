package com.uhutu.dcom.extend.baiduPush.model;

import java.util.LinkedList;
import java.util.List;

import com.uhutu.dcom.extend.baiduPush.constants.BaiduPushConstants;
import com.uhutu.dcom.extend.baiduPush.core.annotation.HttpParamKeyName;
import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;
import com.uhutu.dcom.extend.baiduPush.core.annotation.R;
import com.uhutu.dcom.extend.baiduPush.core.annotation.RangeRestrict;

public class MsgSendInfo {
	
	@HttpParamKeyName(name=BaiduPushConstants.MSG_ID, param=R.REQUIRE)
	@JSonPath(path="msg_id")
	private String msgId = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.MSG_STATUS, param=R.REQUIRE)
	@RangeRestrict(minLength=0, maxLength=3)
	@JSonPath(path="status")
	private Integer msgStatus = null;
	
	@HttpParamKeyName(name=BaiduPushConstants.SEND_TIME, param=R.OPTIONAL)
	@JSonPath(path="send_time")
	private long sendTime;
	
	@HttpParamKeyName(name=BaiduPushConstants.SUCCESS_COUNT, param=R.OPTIONAL)
	@JSonPath(path="success")
	private Integer successCount = null;
	
	@JSonPath(path="detail")
	private List<KeyValueForAck> msgAckInfo = new LinkedList<KeyValueForAck>();
	
	// get
	public String getMsgId () {
		return msgId;
	}
	public Integer getMsgStatus () {
		return msgStatus;
	}
	public Integer getSuccessCount () {
		return successCount;
	}
	public long getSendTime () {
		return sendTime;
	}
	public List<KeyValueForAck> getMsgAckInfo() {
		return msgAckInfo;
	}
	// set
	public void setMsgAckInfo (List<KeyValueForAck> msgAckInfo) {
		this.msgAckInfo = msgAckInfo;
	}
}
