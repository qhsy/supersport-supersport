package com.uhutu.dcom.user.z.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 点赞通知实体
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgPraise extends BaseEntity {
	
	@ZooData(value="内容编号")
	private String contentCode;
	
	@ZooData(value="消息时间")
	private Date msgTime;
	
	@ZooData(value="消息标题")
	private String msgTitle;
	
	@ZooData(value="内容标题")
	private String contentTitle;
	
	@ZooData(value="内容作者")
	private String contentAuthor;
	
	@ZooData(value="点赞相关操作编号")
	private String praiseCode;
	
	@ZooData(value="点赞用户编号")
	private String praiseUserCode;
	
	@ZooData(value="是否已读")
	private String status;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public Date getMsgTime() {
		return msgTime;
	}

	public void setMsgTime(Date msgTime) {
		this.msgTime = msgTime;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContentAuthor() {
		return contentAuthor;
	}

	public void setContentAuthor(String contentAuthor) {
		this.contentAuthor = contentAuthor;
	}

	public String getPraiseCode() {
		return praiseCode;
	}

	public void setPraiseCode(String praiseCode) {
		this.praiseCode = praiseCode;
	}

	public String getPraiseUserCode() {
		return praiseUserCode;
	}

	public void setPraiseUserCode(String praiseUserCode) {
		this.praiseUserCode = praiseUserCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
