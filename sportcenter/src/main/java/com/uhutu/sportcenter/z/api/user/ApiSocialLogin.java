package com.uhutu.sportcenter.z.api.user;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.RandomUtil;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.user.UserCallFactory;
import com.uhutu.zooweb.user.UserReginsterInput;
import com.uhutu.zooweb.user.UserReginsterResult;

/**
 * 社交类账户登录
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiSocialLogin extends RootApiBase<ApiSocialLoginInput, ApiSocialLoginResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	private UserCallFactory userCallFactory = new UserCallFactory();

	public ApiSocialLoginResult process(ApiSocialLoginInput inputParam) {
		
	    ApiSocialLoginResult result = null;
		
	    UserReginsterResult userRegResult = userRegister(inputParam.getAccountId());
	    
	    if(userRegResult.upFlagTrue()){
	    	
	    	result = new ApiSocialLoginResult();
	    	
	    	saveUserInfo(userRegResult, inputParam);
		    
		    saveUserInfoExt(userRegResult.getUserCode(), inputParam);
		    
		    saveSocialInfo(userRegResult.getUserCode(), inputParam);
		    
		    result.setFirstLogin(true);
		    
		    result.setUserToken(userRegResult.getToken());
		    
		    result.setUserCode(userRegResult.getUserCode());
	    	
	    }else{
	    	
	    	result = loginSytem(inputParam.getAccountId());
	    	
	    }

		return result;
	}
	
	/**
	 * 授权系统用户注册
	 * @param accountId
	 * 		社交类平台账户标识
	 * @return 授权系统用户注册结果
	 */
	public UserReginsterResult userRegister(String accountId){
		    
		 UserReginsterInput registInput = new UserReginsterInput();
		    
		 registInput.setLoginName(accountId);
		 
		 registInput.setLoginPass("");
		 
		 registInput.setLoginSystem(DefineUser.Login_System_Default);
		 
		 return userCallFactory.userReginster(registInput);
		
	}
	
	/**
	 * 	保存系统用户信息
	 * @param userRegResult
	 * 		授权系统用户注册结果
	 * @param input
	 * 		系统输入参数
	 * return UcUserinfo
	 */
	public UcUserinfo saveUserInfo(UserReginsterResult userRegResult,ApiSocialLoginInput input){
		
		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(input.getAccountId(),UserEnum.FLAG_ENABLE.getCode());
		
		if(ucUserinfo == null){
			
			ucUserinfo = new UcUserinfo();
			
			ucUserinfo.setCode(userRegResult.getUserCode());
			
			ucUserinfo.setFlag(UserEnum.FLAG_ENABLE.getCode());
			
			ucUserinfo.setLastTime(new Date());
			
			ucUserinfo.setLoginCode(userRegResult.getLoginCode());
			
			ucUserinfo.setLoginName(input.getAccountId());
			
			ucUserinfo.setLoginPwd("");
			
			ucUserinfo.setType(UserEnum.TYPE_CUSTOM.getCode());
			
		}else{
			
			ucUserinfo.setLastTime(new Date());
			
			ucUserinfo.setLoginCode(userRegResult.getLoginCode());
			
			ucUserinfo.setLoginPwd("");
			
		}
		
		userServiceFactory.getUserInfoService().save(ucUserinfo);
		
		return ucUserinfo;
		
	}
	
	/**
	 * 	保存系统用户扩展信息
	 * @param code
	 * 		用户编号
	 * @param input
	 * 		系统输入参数
	 */
	public void saveUserInfoExt(String userCode,ApiSocialLoginInput input){
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
		
		if(ucUserinfoExt == null){
			
			ucUserinfoExt = new UcUserinfoExt();
			
			String nickName = initNickName(input.getAccountName(), userCode);
			
			ucUserinfoExt.setNickName(nickName);
			
			ucUserinfoExt.setUserCode(userCode);
			
			ucUserinfoExt.setAboutHead(input.getAboutHead());
			
			userServiceFactory.getUserInfoExtService().save(ucUserinfoExt);
			
		}
		
	}
	
	/**
	 * 保存用户社交信息
	 * @param userCode
	 * 		用户编号
	 * @param input
	 * 		输入参数
	 */
	public void saveSocialInfo(String userCode, ApiSocialLoginInput input){
		
		UcUserinfoSocial social = userServiceFactory.getUserInfoSocialService().queryByUserCode(userCode);
		
		if(social == null){
			
			social = new UcUserinfoSocial();
			
			social.setAccountId(input.getAccountId());
			
			social.setAccountName(input.getAccountName());
			
			social.setAccountType(input.getAccountType());
			
			social.setUserCode(userCode);
			
		}else{
			
			social.setAccountName(input.getAccountName());
			
		}
		
		userServiceFactory.getUserInfoSocialService().save(social);
		
	}
	
	/**
	 * 初始化昵称
	 * @param nickName
	 * 		昵称名称
	 * @param userCode
	 * 		用户编号
	 * @return 昵称
	 */
	public String initNickName(String nickName,String userCode){
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByNickName(nickName);
		
		if(ucUserinfoExt != null){
			
			if(!StringUtils.equals(userCode, ucUserinfoExt.getUserCode())){
				
				nickName = nickName + RandomUtil.randomNumber(6);
				
			}
			
		}
		
		return nickName;
		
	}
	
	/**
	 * 系统登录
	 * @param openId
	 * 		社交平台openId
	 * @return 社交账户登录信息
	 */
	public ApiSocialLoginResult loginSytem(String openId){
		
		ApiSocialLoginResult loginResult = new ApiSocialLoginResult();
		
    	UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().
    			queryByLoginName(openId,UserEnum.FLAG_ENABLE.getCode());
    	
    	if(ucUserinfo != null){
    		
    		String token = userCallFactory.upAuthCode(ucUserinfo.getLoginCode(), 
	    			ucUserinfo.getCode(), DefineUser.Login_System_Default);
	    	
    		loginResult.setFirstLogin(false);
	    	
    		loginResult.setUserToken(token);
	    	
    		loginResult.setUserCode(ucUserinfo.getCode());
    		
    	}else{
    		
    		loginResult.inError(81100003);
    		
    	}
    
		return loginResult;
		
	}
	

}
