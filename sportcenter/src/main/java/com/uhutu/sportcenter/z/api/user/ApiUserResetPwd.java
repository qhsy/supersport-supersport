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
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserCallFactory;
import com.uhutu.zooweb.user.UserLoginInput;
import com.uhutu.zooweb.user.UserLoginResult;

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
	
	private UserCallFactory userCallFactory = new UserCallFactory();

	@Override
	protected ApiUserResetPwdResult process(ApiUserResetPwdInput input) {

		UcUserinfo ucUserinfo = null;

		ApiUserResetPwdResult resetPwdResult = new ApiUserResetPwdResult();

		switch (input.getVerifyType()) {
		case "resetpwd":

			resetPwd(resetPwdResult, input, ucUserinfo);

			break;

		case "forgetpwd":

			forgetPwd(resetPwdResult, input, ucUserinfo);

			break;

		default:
			break;
		}

		return resetPwdResult;
	}
	
	/**
	 * 忘记密码
	 * @param resetPwdResult
	 * 		处理result
	 * @param input
	 * 		输入参数
	 * @param ucUserinfo
	 * 		用户信息
	 */
	public void forgetPwd(ApiUserResetPwdResult resetPwdResult,ApiUserResetPwdInput input,UcUserinfo ucUserinfo){
		
		ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(input.getLoginName(),UserEnum.FLAG_ENABLE.getCode());
		
		if(ucUserinfo == null){
			
			resetPwdResult.inError(81100003);
			
		}
		
		if(resetPwdResult.upFlagTrue()){
			
			SmsTypeEnum verifyEnum = Enum.valueOf(SmsTypeEnum.class, input.getVerifyType());
			
			RootApiResult rootApiResult = new SmsSupport().upLastVerifyCode(verifyEnum, input.getLoginName(),
					input.getVerifyCode());

			if(rootApiResult.upFlagTrue()){
				
				int count = new UserCallFactory().resetPwd(input.getLoginName(), input.getLoginPwd());
				
				if(count == 1){
					
					ucUserinfo.setLoginPwd(input.getLoginPwd());

					ucUserinfo.setLastTime(new Date());

					userServiceFactory.getUserInfoService().save(ucUserinfo);

					UserLoginResult loginResult = userLogin(ucUserinfo.getLoginName(), ucUserinfo.getLoginPwd());
					
					if(loginResult.upFlagTrue()){
						
						resetPwdResult.setUserCode(loginResult.getUserCode());
						
						resetPwdResult.setUserToken(loginResult.getToken());
						
					}else{
						
						resetPwdResult.setError(loginResult.getError());
						
						resetPwdResult.setStatus(loginResult.getStatus());
						
					}
					
				}
				
			}else{
				
				resetPwdResult.setError(rootApiResult.getError());
				
				resetPwdResult.setStatus(rootApiResult.getStatus());
				
			}
			
		}
		
	}
	
	/**
	 * 重置密码
	 * @param resetPwdResult
	 * 		处理result
	 * @param input
	 * 		输入参数
	 * @param ucUserinfo
	 * 		用户信息
	 */
	public void resetPwd(ApiUserResetPwdResult resetPwdResult,ApiUserResetPwdInput input,UcUserinfo ucUserinfo){
		
		String userCode = new UserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
		
		ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(userCode);
		
		if(ucUserinfo == null){
			
			resetPwdResult.inError(81100003);
			
		}
		
		if(resetPwdResult.upFlagTrue()){
			
			if(StringUtils.equals(ucUserinfo.getLoginPwd(), input.getConfirmPwd())){
				
				int count = new UserCallFactory().resetPwd(ucUserinfo.getLoginName(), input.getLoginPwd());
				
				if(count == 1){
					
					ucUserinfo.setLoginPwd(input.getLoginPwd());

					ucUserinfo.setLastTime(new Date());

					userServiceFactory.getUserInfoService().save(ucUserinfo);	
					
					UserLoginResult loginResult = userLogin(ucUserinfo.getLoginName(), ucUserinfo.getLoginPwd());
					
					if(loginResult.upFlagTrue()){
						
						resetPwdResult.setUserCode(loginResult.getUserCode());
						
						resetPwdResult.setUserToken(loginResult.getToken());
						
					}else{
						
						resetPwdResult.setError(loginResult.getError());
						
						resetPwdResult.setStatus(loginResult.getStatus());
						
					}
					
				}else{
					
					resetPwdResult.inError(81100009);
					
				}
				
			}else{
				
				resetPwdResult.inError(81100005);
				
			}
			
		}
		
	}
	
	
	/**
	 * 用户登录
	 * @param loginName
	 * 		登录名
	 * @param pwd
	 * 		密码
	 * @return 登录结果
	 */
	public UserLoginResult userLogin(String loginName,String pwd){
		
		UserLoginInput loginInput = new UserLoginInput();
		
		loginInput.setLoginName(loginName);
		
		loginInput.setLoginPass(pwd);
		
		loginInput.setLoginSystem(DefineUser.Login_System_Default);
		
		return userCallFactory.userLogin(loginInput);
		
	}

}
