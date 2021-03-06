package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;

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
	
	/**
	 * 根据昵称查询用户信息
	 * @param nickName
	 * 		昵称
	 * @return 用户扩展信息
	 */
	public UcUserinfoExt queryByNickName(String nickName);

}
