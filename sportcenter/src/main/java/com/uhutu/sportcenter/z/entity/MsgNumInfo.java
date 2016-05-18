package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息数量信息
 * @author 逄小帅
 *
 */
public class MsgNumInfo {
	
	@ApiModelProperty(name="消息类型" ,notes="消息类型",example="01:关注 02:评论 03:通知 04:点赞")
	private String msgType;
	
	@ApiModelProperty(name="消息总数" ,notes="消息总数")
	private int total;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}
