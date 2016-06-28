package com.uhutu.dcom.extend.baiduPush.model;

import com.uhutu.dcom.extend.baiduPush.core.annotation.JSonPath;
import com.uhutu.dcom.extend.baiduPush.core.annotation.RangeRestrict;

public class TimerResultInfo {

	@JSonPath(path="timer_id")
	private String timerId = null;

	@JSonPath(path="msg")
	private String message = null;

	@JSonPath(path="send_time")
	private long sendTime;

	@JSonPath(path="msg_type")
	@RangeRestrict(minLength=0, maxLength=1)
	private int msgType;
	
	@JSonPath(path="range_type")
	@RangeRestrict(minLength=0, maxLength=7)
	private int rangeType;
	
	// get
	public String getTimerId () {
		return timerId;
	}
	public String getMessage () {
		return message;
	}
	public long getSendTime () {
		return sendTime;
	}
	public int getMsgType () {
		return msgType;
	}
	public int getRangeType () {
		return rangeType;
	}
}
