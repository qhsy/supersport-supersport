package com.uhutu.dcom.user.z.service;

import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;

/**
 * 社交类账户业务实现
 * @author pang_jhui
 *
 */
public interface IUserInfoSocialService {
	
	/**
	 * 社交类app用户信息保存
	 * @param ucUserinfoSocial
	 */
	public void save(UcUserinfoSocial ucUserinfoSocial);
	
	/**
	 * 社交用户信息查询
	 * @param id
	 * 		主键
	 * @return 社交类用户信息
	 */
	public UcUserinfoSocial query(String id);
	
	/**
	 * 根据用户编号获取社交类用户信息
	 * @param userCode
	 * 		用户编号
	 * @return 社交类用户信息
	 */
	public UcUserinfoSocial queryByUserCode(String userCode);

}
