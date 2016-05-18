package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户通知与用户关联信息表
 * @author 逄小帅
 *
 */
@Entity
public class UcMsgNoticeUser extends BaseEntity {
	
	@ZooData(value="用户编号")
	private String userCode;
	
	@ZooData(value="通知编号")
	private String noticeCode;
	
	@ZooData(value="读取标识")
	private String status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getNoticeCode() {
		return noticeCode;
	}

	public void setNoticeCode(String noticeCode) {
		this.noticeCode = noticeCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
