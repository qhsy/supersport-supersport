package com.uhutu.dcom.content.z.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播主表
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class CnLiveVideoInfo extends BaseEntity {

	@ZooData(name = "房间编号")
	private String code;

	@ZooData(name = "聊天室编号")
	private String chatCode;

	@ZooData(name = "用户编号")
	private String userCode;

	@ZooData(name = "房间状态(是否有效)")
	private String status;

	@ZooData(name = "创建时间")
	private Date zu;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChatCode() {
		return chatCode;
	}

	public void setChatCode(String chatCode) {
		this.chatCode = chatCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getZu() {
		return zu;
	}

	public void setZu(Date zu) {
		this.zu = zu;
	}

}
