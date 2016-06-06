package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息点赞信息
 * @author 逄小帅
 *
 */
public class MsgPraiseInfo extends UserBasicInfo {
	
	@ApiModelProperty(name="点赞者")
	private String praiseUserCode;
	
	@ApiModelProperty(name="内容标题")
	private String contentTitle;
	
	@ApiModelProperty(name="消息时间")
	private String msgTime;

	public String getPraiseUserCode() {
		return praiseUserCode;
	}

	public void setPraiseUserCode(String praiseUserCode) {
		this.praiseUserCode = praiseUserCode;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}
	
	

}
