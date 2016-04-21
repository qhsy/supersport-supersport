package com.uhutu.sportcenter.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.entity.UserInfo;
import com.uhutu.sportcenter.api.input.ApiUserInfoInput;
import com.uhutu.sportcenter.api.result.ApiUserInfoResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户信息展示
 * @author pang_jhui
 *
 */
@Service
public class ApiUserInfo extends RootApiBase< ApiUserInfoInput,ApiUserInfoResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;
	
	public ApiUserInfoResult process(ApiUserInfoInput inputParam ) {
		
		ApiUserInfoResult userInfoResult = new ApiUserInfoResult();
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
				.queryByUserCode(inputParam.getUserCode());
		
		UserInfo apiUserInfo = new UserInfo();
		
		BeanUtils.copyProperties(ucUserinfoExt, apiUserInfo);
		
		userInfoResult.setUserInfo(apiUserInfo);
		
		return userInfoResult;
	}

}
