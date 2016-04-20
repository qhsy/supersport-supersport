package com.uhutu.dcom.user.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户信息
 * @author pang_jhui
 *
 */
@Entity
public class UcUserinfo extends BaseEntity {
	
	@ZooData(name="用户编号")
	private String code;
	
	@ZooData(name="登录名称")
	private String loginName;
	
	@ZooData(name="登录密码")
	private String loginPwd;
	
	@ZooData(name="是否可用")
	private String flag;

	/**
	 * 获取用户编号
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置用户编号
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取登录名称
	 * @return
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录名称
	 * @param loginName
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 设置登录密码
	 * @return
	 */
	public String getLoginPwd() {
		return loginPwd;
	}

	/**
	 * 设置登录密码
	 * @param loginPwd
	 */
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	/**
	 * 获取是否可用
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 设置是否可用
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	

}
