package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

@Entity
public class UcSigInfo extends BaseEntity {

	@ZooData(value = "用户编号")
	@Column(length = 20)
	private String userCode;

	@ZooData(value = "sig授权信息")
	@Column(length = 500)
	private String sig;

	@ZooData(value = "过期时间")
	private String expireTime;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

}
