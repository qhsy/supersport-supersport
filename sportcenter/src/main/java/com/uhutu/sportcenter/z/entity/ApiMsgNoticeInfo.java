package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知
 * @author 逄小帅
 *
 */
public class ApiMsgNoticeInfo {
	
	@ApiModelProperty(value="图标信息")
	private String iconUrl;
	
	@ApiModelProperty(value="标题信息")
	private String title;
	
	@ApiModelProperty(value="未读的数量")
	private int unReadNum;
	
	@ApiModelProperty(value="消息内容")
	private MsgNoticeInfo msgNoticeInfo;

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MsgNoticeInfo getMsgNoticeInfo() {
		return msgNoticeInfo;
	}

	public void setMsgNoticeInfo(MsgNoticeInfo msgNoticeInfo) {
		this.msgNoticeInfo = msgNoticeInfo;
	}

	public int getUnReadNum() {
		return unReadNum;
	}

	public void setUnReadNum(int unReadNum) {
		this.unReadNum = unReadNum;
	}

}
