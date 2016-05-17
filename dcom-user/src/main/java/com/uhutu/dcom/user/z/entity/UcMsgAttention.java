package com.uhutu.dcom.user.z.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户关注消息
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgAttention extends BaseEntity {
	
	@ZooData(value="粉丝用户编号")
	private String fansUserCode;
	
	@ZooData(value="关注人用户编号")
	private String attnUserCode;
	
	@ZooData(value="消息标题")
	private String msgTitle;
	
	@ZooData(value="消息时间")
	private Date msgTime;
	
	@ZooData(value="是否已读标识")
	private String flag;

	public String getFansUserCode() {
		return fansUserCode;
	}

	public void setFansUserCode(String fansUserCode) {
		this.fansUserCode = fansUserCode;
	}

	public String getAttnUserCode() {
		return attnUserCode;
	}

	public void setAttnUserCode(String attnUserCode) {
		this.attnUserCode = attnUserCode;
	}

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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
