package com.uhutu.dcom.user.z.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.SpAppVersion;
import com.uhutu.dcom.user.z.service.IAppVersionService;
/**
 * 
 * @author 逄小帅
 *
 */
@Service
public class AppVersionServiceImpl implements IAppVersionService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public SpAppVersion queryOrderByZcDesc(String systemType) {
		
		return userDaoFactory.getAppVersionDao().queryOrderByZcDesc(systemType);
		
	}

}
