package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 消息通知实体
 * 
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgNotice extends BaseEntity {

	@ZooData(value = "通知编号")
	private String code;

	@ZooData(value = "通知标题")
	private String title;

	@ZooData(value = "消息内容")
	private String content;

	@ZooData(value = "通知类型")
	private String type;

	@ZooData(value = "通知时间")
	private String notifyTime;

	@ZooData(value = "状态")
	private String status;

	@ZooData(value = "发送类型")
	private String sendType;

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
