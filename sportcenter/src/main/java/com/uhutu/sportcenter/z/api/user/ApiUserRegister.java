package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.sms.SmsSupport;
import com.uhutu.dcom.extend.sms.SmsTypeEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserRegInput;
import com.uhutu.sportcenter.z.result.ApiUserRegResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.root.RootApiResult;

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
		RootApiResult rootApiResult = new SmsSupport().upLastVerifyCode(SmsTypeEnum.register, inputParam.getLoginName(),
				inputParam.getVerify_code());
		if (rootApiResult.getStatus() == 1) {

			UcUserinfo ucUserinfo = new UcUserinfo();

			ucUserinfo.setLoginName(inputParam.getLoginName());

			ucUserinfo.setLoginPwd(inputParam.getPassword());

			userServiceFactory.getUserInfoService().save(ucUserinfo);

			userRegResult.setUserCode(ucUserinfo.getCode());

			userRegResult.setUserToken(ucUserinfo.getCode());
		} else {
			userRegResult.setStatus(rootApiResult.getStatus());
			userRegResult.setError(rootApiResult.getError());
		}

		return userRegResult;

	}

}
