package com.uhutu.sportcenter.z.api.user;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.dcom.extend.sms.SmsSupport;
import com.uhutu.dcom.extend.sms.SmsTypeEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
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

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(input.getLoginName(),UserEnum.FLAG_ENABLE.getCode());

		ApiUserResetPwdResult resetPwdResult = new ApiUserResetPwdResult();

		if (ucUserinfo != null) {
			
			

		} else {

			resetPwdResult.setError("该用户信息不存在");

			resetPwdResult.setStatus(0);

		}

		return resetPwdResult;
	}
	
	public void resetPwd(ApiUserResetPwdResult resetPwdResult,ApiUserResetPwdInput input,UcUserinfo ucUserinfo){
		
		SmsTypeEnum verifyEnum = Enum.valueOf(SmsTypeEnum.class, input.getVerifyType());
		
		RootApiResult rootApiResult = new SmsSupport().upLastVerifyCode(verifyEnum, input.getLoginName(),
				input.getVerifyCode());

		if(rootApiResult.upFlagTrue()){
			
			ucUserinfo.setLoginPwd(input.getLoginPwd());

			ucUserinfo.setLastTime(new Date());

			userServiceFactory.getUserInfoService().save(ucUserinfo);

			resetPwdResult.setUserToken(ucUserinfo.getCode());
			
		}else{
			
			resetPwdResult.setError(rootApiResult.getError());
			
			resetPwdResult.setStatus(rootApiResult.getStatus());
			
		}
		
	}
	
	public void forgetPwd(ApiUserResetPwdResult resetPwdResult,ApiUserResetPwdInput input,UcUserinfo ucUserinfo){
		
		if(StringUtils.equals(ucUserinfo.getLoginPwd(), input.getConfirmPwd())){
			
			ucUserinfo.setLoginPwd(input.getLoginPwd());

			ucUserinfo.setLastTime(new Date());

			userServiceFactory.getUserInfoService().save(ucUserinfo);

			resetPwdResult.setUserToken(ucUserinfo.getCode());
			
		}else{
			
			resetPwdResult.inError(81100005);
			
		}
		
	}

}
