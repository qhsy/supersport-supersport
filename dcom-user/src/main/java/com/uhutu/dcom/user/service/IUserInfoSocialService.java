package com.uhutu.dcom.user.service;

import com.uhutu.dcom.user.entity.UcUserinfoSocial;

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

}
