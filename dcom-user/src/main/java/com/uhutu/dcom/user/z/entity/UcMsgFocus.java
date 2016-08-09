package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 消息关注
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode","msgType" }))
public class UcMsgFocus extends BaseEntity {

	@ZooData(value="用户编号")
	@Column(length=50)
	private String userCode;
	
	@ZooData(value="消息类型")
	@Column(length=20)
	private String msgType;
	
	@ZooData(value="关注状态")
	@Column(length=50)
	private String status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
