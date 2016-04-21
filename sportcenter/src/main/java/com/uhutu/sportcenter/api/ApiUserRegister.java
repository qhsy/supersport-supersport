package com.uhutu.sportcenter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.input.ApiUserRegInput;
import com.uhutu.sportcenter.api.result.ApiUserRegResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户注册接口api
 * @author pang_jhui
 *
 */
@Service
public class ApiUserRegister extends RootApiBase< ApiUserRegInput,ApiUserRegResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;
	
	public ApiUserRegResult process(ApiUserRegInput inputParam) {
		
		ApiUserRegResult userRegResult = new ApiUserRegResult();
		
		UcUserinfo ucUserinfo = new UcUserinfo();
		
		ucUserinfo.setLoginName(inputParam.getLoginName());
		
		ucUserinfo.setLoginPwd(inputParam.getPassword());
		
		userServiceFactory.getUserInfoService().save(ucUserinfo);
		
		userRegResult.setUserCode(ucUserinfo.getCode());
		
		userRegResult.setToken(ucUserinfo.getCode());
		
		return userRegResult;
		
	}

	

}
