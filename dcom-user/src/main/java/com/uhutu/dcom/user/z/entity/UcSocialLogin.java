package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户社交登录信息
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"openid","unionid"}))
public class UcSocialLogin extends BaseEntity {
	
	@ZooData(value = "用户标识")
	@Column(length = 50)
	private String openid;
	
	@ZooData(value = "平台用户标识")
	@Column(length = 50)
	private String unionid;
	
	@ZooData(value = "平台类型")
	@Column(length = 50)
	private String type;

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
