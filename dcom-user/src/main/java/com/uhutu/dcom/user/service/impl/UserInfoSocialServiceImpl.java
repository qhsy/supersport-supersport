package com.uhutu.dcom.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.dao.UserDaoFacotry;
import com.uhutu.dcom.user.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.service.IUserInfoSocialService;

/**
 * 社交类用户业务实现
 * @author pang_jhui
 *
 */
@Service
public class UserInfoSocialServiceImpl implements IUserInfoSocialService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcUserinfoSocial ucUserinfoSocial) {
		
		userDaoFacotry.getUserInfoSocialDao().save(ucUserinfoSocial);
		
	}

	@Override
	public UcUserinfoSocial query(String id) {
		
		return userDaoFacotry.getUserInfoSocialDao().findOne(id);
		
	}

	@Override
	public UcUserinfoSocial queryByUserCode(String userCode) {
		
		return userDaoFacotry.getUserInfoSocialDao().queryByUserCode(userCode);
		
	}

}
