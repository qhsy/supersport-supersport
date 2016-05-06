package com.uhutu.sportcenter.z;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserRegInput;
import com.uhutu.sportcenter.z.result.ApiUserRegResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户注册接口api
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiUserRegister extends RootApiBase<ApiUserRegInput, ApiUserRegResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiUserRegResult process(ApiUserRegInput inputParam) {

		ApiUserRegResult userRegResult = new ApiUserRegResult();

		UcUserinfo ucUserinfo = new UcUserinfo();

		ucUserinfo.setLoginName(inputParam.getLoginName());

		ucUserinfo.setLoginPwd(inputParam.getPassword());

		userServiceFactory.getUserInfoService().save(ucUserinfo);

		userRegResult.setUserCode(ucUserinfo.getCode());

		userRegResult.setUserToken(ucUserinfo.getCode());

		return userRegResult;

	}

}
