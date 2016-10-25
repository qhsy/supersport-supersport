package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户注册时关注信息
 * @author 逄小帅
 *
 */
@Entity
public class UcAttendReg extends BaseEntity {
	
	@ZooData(value = "关注用户编号")
	private String userCode;
	
	@ZooData(value="关注状态")
	private String status;

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

}
