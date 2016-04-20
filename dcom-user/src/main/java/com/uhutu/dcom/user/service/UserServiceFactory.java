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

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}
	
	

}
