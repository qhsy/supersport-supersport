package com.uhutu.dcom.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户数据访问
 * @author pang_jhui
 *
 */
@Component
public class UserDaoFacotry {
	
	@Autowired
	private IUserInfoDao userInfoDao;
	
	@Autowired 
	private IUserInfoExtDao userInfoExtDao;
	
	@Autowired
	private IUserInfoSocialDao userInfoSocialDao;

	/**
	 * 用户信息数据访问
	 * @return
	 */
	public IUserInfoDao getUserInfoDao() {
		return userInfoDao;
	}

	/**
	 * 用户扩展信息数据访问
	 * @return
	 */
	public IUserInfoExtDao getUserInfoExtDao() {
		return userInfoExtDao;
	}

	/**
	 * 社交类账户数据访问
	 * @return
	 */
	public IUserInfoSocialDao getUserInfoSocialDao() {
		return userInfoSocialDao;
	}

}
