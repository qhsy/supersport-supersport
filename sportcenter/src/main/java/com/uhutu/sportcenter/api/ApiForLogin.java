package com.uhutu.sportcenter.api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.enums.UserEnum;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.input.ApiForLoginInput;
import com.uhutu.sportcenter.api.result.ApiForLoginResult;
import com.uhutu.zoocom.root.RootApiBase;

/***
 * 登录
 * 
 * @author xiegj *
 */
@Service
public class ApiForLogin extends RootApiBase<ApiForLoginInput, ApiForLoginResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiForLoginResult process(ApiForLoginInput inputParam) {

		ApiForLoginResult result = new ApiForLoginResult();

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(inputParam.getLoginName());

		if(ucUserinfo != null){
			
			ucUserinfo.setFlag(UserEnum.FLAG_LOGIN.getCode());
			
			ucUserinfo.setLastTime(new Date());
			
			userServiceFactory.getUserInfoService().save(ucUserinfo);
			
			result.setUserToken(ucUserinfo.getCode());
			
		}else{
			
			result.setStatus(0);
			
			result.setError("用户信息不存在，请确认输入登录账户");
			
		}
		
		return result;

	}
}
