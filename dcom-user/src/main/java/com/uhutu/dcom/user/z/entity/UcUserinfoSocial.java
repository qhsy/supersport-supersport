package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 社交app相关用户信息
 * @author pang_jhui
 *
 */
@Entity
public class UcUserinfoSocial extends BaseEntity {
	
	@ZooData(name="用户编号")
	private String userCode;
	
	@ZooData(name="社交类账户平台标识")
	private String accountId;
	
	@ZooData(name="账户类型")
	private String accountType;
	
	@ZooData(name="账户昵称")
	private String accountName;

	/**
	 * 用户编号
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 设置用户编号
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * 获取社交类账户平台标识
	 * @return
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * 设置社交类账户平台标识
	 * @param accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * 获取账户类型
	 * @return
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * 设置账户类型
	 * @param accountType
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * 获取账户名称
	 * @return
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * 设置账户名称
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

}
