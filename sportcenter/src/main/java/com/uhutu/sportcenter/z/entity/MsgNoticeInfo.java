package com.uhutu.sportcenter.z.entity;

import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知信息
 * @author 逄小帅
 *
 */
public class MsgNoticeInfo {
	
	@ApiModelProperty(name="消息时间")
	private Date notifyTime;
	
	@ApiModelProperty(name="消息内容")
	private String content;

	public Date getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Date notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
