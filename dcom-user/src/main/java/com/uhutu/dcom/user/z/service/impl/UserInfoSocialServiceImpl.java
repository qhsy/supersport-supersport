package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.service.IUserInfoSocialService;

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
		
		if(StringUtils.isNoneEmpty(ucUserinfoSocial.getZa()) && userDaoFacotry.getUserInfoSocialDao().exists(ucUserinfoSocial.getZa())){
			
			ucUserinfoSocial.setZu(new Date());
			
		}else{
			
			ucUserinfoSocial.setZc(new Date());
			
		}
		
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
