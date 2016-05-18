package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户消息状态
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgStatus extends BaseEntity {
	
	@ZooData(value="消息类型")
	private String msgType;
	
	@ZooData(value="用户编号")
	private String userCode;
	
	@ZooData(value="是否已读")
	private String flag;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
