package com.uhutu.dcom.user.z.entity;

/**
 * 用户基本信息
 * @author pang_jhui
 *
 */
public class UserBasicInfo {
	
	/**用户登录信息*/
	private UcUserinfo ucUserinfo;
	
	/**用户扩展信息*/
	private UcUserinfoExt ucUserinfoExt;
	
	/**用户社交信息*/
	private UcUserinfoSocial ucUserinfoSocial;

	/**
	 * 获取用户信息
	 * @return
	 */
	public UcUserinfo getUcUserinfo() {
		return ucUserinfo;
	}

	/**
	 * 设置用户信息
	 * @param ucUserinfo
	 */
	public void setUcUserinfo(UcUserinfo ucUserinfo) {
		this.ucUserinfo = ucUserinfo;
	}

	/**
	 * 用户扩展信息
	 * @return
	 */
	public UcUserinfoExt getUcUserinfoExt() {
		return ucUserinfoExt;
	}

	/**
	 * 设置用户扩展信息
	 * @param ucUserinfoExt
	 */
	public void setUcUserinfoExt(UcUserinfoExt ucUserinfoExt) {
		this.ucUserinfoExt = ucUserinfoExt;
	}

	/**
	 * 社交账户信息
	 * @return
	 */
	public UcUserinfoSocial getUcUserinfoSocial() {
		return ucUserinfoSocial;
	}

	/**
	 * 设置社交账户信息
	 * @param ucUserinfoSocial
	 */
	public void setUcUserinfoSocial(UcUserinfoSocial ucUserinfoSocial) {
		this.ucUserinfoSocial = ucUserinfoSocial;
	}
	
	

}
