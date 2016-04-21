package com.uhutu.dcom.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户业务处理
 * @author pang_jhui
 *
 */
@Component
public class UserServiceFactory {
	
	@Autowired
	private IUserInfoService userInfoService;
	
	@Autowired
	private IUserInfoExtService userInfoExtService;
	
	@Autowired
	private IUserInfoSocialService userInfoSocialService;

	/**
	 * 获取用户业务实现
	 * @return IUserInfoService
	 */
	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}

	/**
	 * 用户扩展信息业务实现
	 * @return IUserInfoExtService
	 */
	public IUserInfoExtService getUserInfoExtService() {
		return userInfoExtService;
	}

	/**
	 * 社交类用户信息业务处理
	 * @return IUserInfoSocialService
	 */
	public IUserInfoSocialService getUserInfoSocialService() {
		return userInfoSocialService;
	}
	
	

}
