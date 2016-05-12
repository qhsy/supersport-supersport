package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserResetPwdInput;
import com.uhutu.sportcenter.z.result.ApiUserResetPwdResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户重置密码
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiUserResetPwd extends RootApiBase<ApiUserResetPwdInput, ApiUserResetPwdResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserResetPwdResult process(ApiUserResetPwdInput input) {

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(input.getLoginName());

		ApiUserResetPwdResult resetPwdResult = new ApiUserResetPwdResult();

		if (ucUserinfo != null) {

			ucUserinfo.setLoginPwd(input.getLoginPwd());

			ucUserinfo.setLastTime(new Date());

			userServiceFactory.getUserInfoService().save(ucUserinfo);

			resetPwdResult.setUserToken(ucUserinfo.getCode());

		} else {

			resetPwdResult.setError("该用户信息不存在");

			resetPwdResult.setStatus(0);

		}

		return resetPwdResult;
	}

}