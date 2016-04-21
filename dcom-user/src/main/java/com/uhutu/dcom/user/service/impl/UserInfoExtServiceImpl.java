package com.uhutu.dcom.user.service.impl;

import com.uhutu.dcom.user.dao.UserDaoFacotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.service.IUserInfoExtService;

/**
 * 用户扩展信息保存
 * @author pang_jhui
 *
 */
@Service
public class UserInfoExtServiceImpl implements IUserInfoExtService {
	
	@Autowired
	private UserDaoFacotry userDaoFacotry;

	@Override
	public void save(UcUserinfoExt ucUserinfoExt) {
		
		userDaoFacotry.getUserInfoExtDao().save(ucUserinfoExt);

	}

	@Override
	public UcUserinfoExt query(String id) {
		
		return userDaoFacotry.getUserInfoExtDao().findOne(id);
		
	}

}
