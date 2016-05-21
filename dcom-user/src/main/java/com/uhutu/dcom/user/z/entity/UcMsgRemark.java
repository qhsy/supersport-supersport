package com.uhutu.dcom.user.z.entity;

import java.util.Date;

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
	private Date msgTime;
	
	@ZooData(value="评论编号")
	private String remarkCode;
	
	@ZooData(value="内容编号")
	private String contentCode;
	
	@ZooData(value="内容标题")
	private String contentTitle;
	
	@ZooData(value="内容作者")
	private String contentAuthor;
	
	@ZooData(value="是否已读标识")
	private String status;
	
	@ZooData(value="评论引用")
	private String remarkParentCode;

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContentAuthor() {
		return contentAuthor;
	}

	public void setContentAuthor(String contentAuthor) {
		this.contentAuthor = contentAuthor;
	}

	public String getRemarkParentCode() {
		return remarkParentCode;
	}

	public void setRemarkParentCode(String remarkParentCode) {
		this.remarkParentCode = remarkParentCode;
	}

}
