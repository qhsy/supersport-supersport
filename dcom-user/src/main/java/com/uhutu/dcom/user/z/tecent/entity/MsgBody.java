package com.uhutu.dcom.user.z.tecent.entity;

import com.uhutu.dcom.user.z.tecent.entity.face.MsgContentInterface;

public class MsgBody {
	private String MsgType = "";
	private MsgContentInterface MsgContent;

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public MsgContentInterface getMsgContent() {
		return MsgContent;
	}

	public void setMsgContent(MsgContentInterface msgContent) {
		MsgContent = msgContent;
	}

}
