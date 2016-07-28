package com.uhutu.sportcenter.z.api.user;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.config.enums.SocialEnum;
import com.uhutu.dcom.pay.z.request.WechatAuthRequest;
import com.uhutu.dcom.pay.z.request.WechatUserInfoRequest;
import com.uhutu.dcom.pay.z.response.WechatAuthResponse;
import com.uhutu.dcom.pay.z.response.WechatUserInfoResponse;
import com.uhutu.dcom.pay.z.service.PayServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput2;
import com.uhutu.sportcenter.z.input.ApiWechatUserLoginInput2;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult2;
import com.uhutu.sportcenter.z.result.ApiWechatUserLoginResult2;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 微信登录
 * @author 逄小帅
 *
 */
@Component
public class ApiWechatUserLogin2 extends RootApiBase<ApiWechatUserLoginInput2, ApiWechatUserLoginResult2> {
	
	@Autowired
	private PayServiceFactory payServiceFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private ApiSocialLogin2 apiSocialLogin;

	@Override
	protected ApiWechatUserLoginResult2 process(ApiWechatUserLoginInput2 input) {
		
		ApiWechatUserLoginResult2 userLoginResult = new ApiWechatUserLoginResult2();

		WechatAuthRequest authRequest = new WechatAuthRequest();

		authRequest.setCode(input.getCode());

		/*根据用户授权登录返回code，获取接口调用的accesstoken*/
		WechatAuthResponse authResponse = (WechatAuthResponse) payServiceFactory.getWechatAuthService()
				.doProcess(authRequest, new MDataMap());
		
		if(!authResponse.upFlag()){
			
			userLoginResult.setStatus(0);
			
			userLoginResult.setError(authResponse.getErrmsg());
			
			return userLoginResult;
			
		}
		
		UcUserinfoSocial userInfoSocial = userServiceFactory.getUserInfoSocialService().queryByOpenId(authResponse.getUnionid());

		/*根据openid判断用户是否已经注册过，若是没有则进行注册*/
		if (userInfoSocial == null) {

			WechatUserInfoRequest wechatRequest = new WechatUserInfoRequest();

			wechatRequest.setAccess_token(authResponse.getAccess_token());

			wechatRequest.setOpenid(authResponse.getOpenid());

			WechatUserInfoResponse wechatResponse = (WechatUserInfoResponse) payServiceFactory
					.getWechatUserInfoService().doProcess(wechatRequest, new MDataMap());
			
			ApiSocialLoginResult2 socialLoginResult = socialLogin(wechatResponse);
			
			BeanUtils.copyProperties(socialLoginResult, userLoginResult);
			

		}else{
			
			ApiSocialLoginInput2 loginInput = new ApiSocialLoginInput2();
			
			loginInput.setOpenid(authResponse.getOpenid());
			
			loginInput.setAccountId(authResponse.getUnionid());
			
			loginInput.setAccountType(SocialEnum.wechat_h5.name());
			
			apiSocialLogin.saveSocialLogin(loginInput);
			
			ApiSocialLoginResult2 socialLoginResult = apiSocialLogin.loginSytem(authResponse.getUnionid());
			
			BeanUtils.copyProperties(socialLoginResult, userLoginResult);
			
		}
		

		return userLoginResult;
	}
	
	/**
	 * 
	 * @param wechatResponse
	 * 		微信响应信息
	 * @return 微信登录后信息
	 */
	public ApiSocialLoginResult2 socialLogin(WechatUserInfoResponse wechatResponse){
		
		ApiSocialLoginInput2 input = new ApiSocialLoginInput2();
		
		input.setAboutHead(wechatResponse.getHeadimgurl());
		
		input.setAccountId(wechatResponse.getUnionid());
		
		input.setAccountName(wechatResponse.getNickname());
		
		input.setAccountType(SocialEnum.wechat_h5.name());
		
		input.setOpenid(wechatResponse.getOpenid());
		
		return apiSocialLogin.api(input);		
		
	}

	

}
