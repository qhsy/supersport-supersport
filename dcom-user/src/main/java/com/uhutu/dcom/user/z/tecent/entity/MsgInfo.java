package com.uhutu.dcom.user.z.tecent.entity;

import java.util.Random;

import com.uhutu.dcom.user.z.tecent.entity.face.TecnetBaseEntityInterface;

public class MsgInfo implements TecnetBaseEntityInterface {

	/**
	 * 消息发送方账号。（用于指定发送消息方账号） （可选填）
	 */
	private String From_Account;

	/**
	 * 消息接收方账号。
	 */
	private String To_Account;

	/**
	 * 消息随机数,由随机函数产生。（用作消息去重）
	 */
	private int MsgRandom = new Random().nextInt(929496729);

	/**
	 * 消息时间戳，unix时间戳。
	 */
	private int MsgTimeStamp = (int) (System.currentTimeMillis() / 1000);

	MsgBody[] MsgBody = new MsgBody[1];

	public String getFrom_Account() {
		return From_Account;
	}

	public void setFrom_Account(String from_Account) {
		From_Account = from_Account;
	}

	public String getTo_Account() {
		return To_Account;
	}

	public void setTo_Account(String to_Account) {
		To_Account = to_Account;
	}

	public int getMsgRandom() {
		return MsgRandom;
	}

	public void setMsgRandom(int msgRandom) {
		MsgRandom = msgRandom;
	}

	public int getMsgTimeStamp() {
		return MsgTimeStamp;
	}

	public void setMsgTimeStamp(int msgTimeStamp) {
		MsgTimeStamp = msgTimeStamp;
	}

	public MsgBody[] getMsgBody() {
		return MsgBody;
	}

	public void setMsgBody(MsgBody[] msgBody) {
		MsgBody = msgBody;
	}

}
