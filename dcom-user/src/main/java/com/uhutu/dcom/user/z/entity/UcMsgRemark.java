package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户评论通知
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgRemark extends BaseEntity {
	
	@ZooData(value="消息标题")
	private String msgTitle;
	
	@ZooData(value="消息时间")
	private String msgTime;
	
	@ZooData(value="评论编号")
	private String remarkCode;
	
	@ZooData(value="内容编号")
	private String contentCode;
	
	@ZooData(value="内容标题")
	private String contentTitle;

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(String msgTime) {
		this.msgTime = msgTime;
	}

	public String getRemarkCode() {
		return remarkCode;
	}

	public void setRemarkCode(String remarkCode) {
		this.remarkCode = remarkCode;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

}
