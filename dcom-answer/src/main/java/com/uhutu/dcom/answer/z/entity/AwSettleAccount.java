package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"userCode","openid"}))
public class AwSettleAccount extends BaseEntity {
	
	@ZooData(name = "用户编号")
	@Column(length = 50)
	private String userCode;
	
	@ZooData(name = "应用标识")
	@Column(length = 80)
	private String appid;
	
	@ZooData(name = "用户标识")
	@Column(length = 80)
	private String openid;
	
	@ZooData(name = "用户统一标识")
	@Column(length = 80)
	private String unionid;
	
	@ZooData(name = "结算账户类型")
	@Column(length = 50)
	private String type;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	
	

}
