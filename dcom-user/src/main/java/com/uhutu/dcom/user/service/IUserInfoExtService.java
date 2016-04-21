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
	
	/**
	 * 根据用户编号获取用户扩展信息
	 * @param userCode
	 * 		用户编号
	 * @return 用户扩展信息
	 */
	public UcUserinfoExt queryByUserCode(String userCode);

}
