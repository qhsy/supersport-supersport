package com.uhutu.dcom.user.service;

import com.uhutu.dcom.user.entity.UcUserinfoExt;

/**
 * 
 * @author pang_jhui
 *
 */
public interface IUserInfoExtService {
	
	/**
	 * 用户扩展信息更新
	 * @param ucUserinfoExt
	 */
	public void save(UcUserinfoExt ucUserinfoExt);
	
	/**
	 * 根据用户主键查询用户信息
	 * @param id
	 * 		主键
	 * @return 用户扩展信息
	 */
	public UcUserinfoExt query(String id);

}
