package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcSocialLogin;
import com.uhutu.dcom.user.z.service.IUserSocialLoginService;

/**
 * 用户社交登录信息
 * @author 逄小帅
 *
 */
@Service
public class UserSocialLoginServiceImpl implements IUserSocialLoginService {
	
	@Autowired
	private UserDaoFacotry userDaoFactory;

	@Override
	public void save(UcSocialLogin ucSocialLogin) {
		
		if (StringUtils.isNoneBlank(ucSocialLogin.getZa()) && userDaoFactory.getUserSocialLoginDao().exists(ucSocialLogin.getZa())) {

			ucSocialLogin.setZu(new Date());

			userDaoFactory.getUserSocialLoginDao().save(ucSocialLogin);

		} else {

			ucSocialLogin.setZc(new Date());

			userDaoFactory.getUserSocialLoginDao().save(ucSocialLogin);

		}
		
	}

	@Override
	public UcSocialLogin queryByUnionId(String type,String unionid) {
		
		return userDaoFactory.getUserSocialLoginDao().queryByUnionId(type,unionid);
		
	}
	
	

}
