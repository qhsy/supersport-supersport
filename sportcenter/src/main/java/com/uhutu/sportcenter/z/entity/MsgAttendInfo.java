package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知信息
 * @author 逄小帅
 *
 */
public class MsgAttendInfo {
	
	@ApiModelProperty(name="用户头像")
	private String headUrl;
	
	@ApiModelProperty(name="用户昵称")
	private String nickName;
	
	@ApiModelProperty(name="粉丝用户编号")
	private String fansUserCode;
	
	@ApiModelProperty(name="消息时间")
	private String msgTime;
	
	@ApiModelProperty(name="是否已关注")
	private String attendStatus;

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getFansUserCode() {
		return fansUserCode;
	}

	public void setFansUserCode(String fansUserCode) {
		this.fansUserCode = fansUserCode;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getAttendStatus() {
		return attendStatus;
	}

	public void setAttendStatus(String attendStatus) {
		this.attendStatus = attendStatus;
	}

}
