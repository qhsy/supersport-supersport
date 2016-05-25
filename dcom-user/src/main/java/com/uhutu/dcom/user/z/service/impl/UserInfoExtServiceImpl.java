package com.uhutu.dcom.user.z.service.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.user.z.dao.UserDaoFacotry;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.IUserInfoExtService;

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
		
		if (StringUtils.isNoneBlank(ucUserinfoExt.getZa()) && userDaoFacotry.getUserInfoDao().exists(ucUserinfoExt.getZa())) {

			ucUserinfoExt.setZu(new Date());

			userDaoFacotry.getUserInfoExtDao().save(ucUserinfoExt);

		} else {

			ucUserinfoExt.setZc(new Date());

			userDaoFacotry.getUserInfoExtDao().save(ucUserinfoExt);

		}

	}

	@Override
	public UcUserinfoExt query(String id) {
		
		return userDaoFacotry.getUserInfoExtDao().findOne(id);
		
	}

	@Override
	public UcUserinfoExt queryByUserCode(String userCode) {
		
		return userDaoFacotry.getUserInfoExtDao().queryByUserCode(userCode);
		
	}

	@Override
	public UcUserinfoExt queryByNickName(String nickName) {
		
		return userDaoFacotry.getUserInfoExtDao().queryByNickName(nickName);
		
	}

}
