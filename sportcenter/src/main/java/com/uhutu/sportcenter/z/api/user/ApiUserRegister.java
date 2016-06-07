package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.dcom.extend.sms.SmsSupport;
import com.uhutu.dcom.extend.sms.SmsTypeEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserRegInput;
import com.uhutu.sportcenter.z.result.ApiUserRegResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserReginsterResult;

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
			
			UserReginsterResult userAuthResult = userServiceFactory.getUserInfoService().regAuthUser(inputParam.getLoginName(), inputParam.getPassword());

			if(userAuthResult.upFlagTrue()){
				
				UcUserinfo ucUserinfo = new UcUserinfo();

				ucUserinfo.setLoginName(inputParam.getLoginName());

				ucUserinfo.setLoginPwd(inputParam.getPassword());
				
				ucUserinfo.setFlag(UserEnum.FLAG_ENABLE.getCode());
				
				ucUserinfo.setLastTime(new Date());
				
				ucUserinfo.setLoginCode(userAuthResult.getLoginCode());
				
				ucUserinfo.setCode(userAuthResult.getUserCode());
				
				ucUserinfo.setType(UserEnum.TYPE_CUSTOM.getCode());
				
				ucUserinfo.setMjFlag(SystemEnum.NO.getCode());

				userServiceFactory.getUserInfoService().save(ucUserinfo);
				
				UcUserinfoExt ucUserinfoExt = new UcUserinfoExt();
				
				ucUserinfoExt.setUserCode(ucUserinfo.getCode());
				
				ucUserinfoExt.setNickName(inputParam.getNickName());
				
				userServiceFactory.getUserInfoExtService().save(ucUserinfoExt);

				userRegResult.setUserCode(userAuthResult.getUserCode());

				userRegResult.setUserToken(userAuthResult.getToken());
				
			}else{
				
				userRegResult.inError(81100002);
				
			}
			
		} else {
			userRegResult.setStatus(rootApiResult.getStatus());
			userRegResult.setError(rootApiResult.getError());
		}

		return userRegResult;

	}
	
	

}
