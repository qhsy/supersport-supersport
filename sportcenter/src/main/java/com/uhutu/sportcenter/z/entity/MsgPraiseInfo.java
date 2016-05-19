package com.uhutu.sportcenter.z.entity;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息点赞信息
 * @author 逄小帅
 *
 */
public class MsgPraiseInfo {
	
	@ApiModelProperty(name="头像")
	private String headUrl;
	
	@ApiModelProperty(name="昵称")
	private String nickName;
	
	@ApiModelProperty(name="点赞者")
	private String praiseUserCode;
	
	@ApiModelProperty(name="内容标题")
	private String contentTitle;
	
	@ApiModelProperty(name="消息时间")
	private Date msgTime;

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

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}
	
	

}
