package com.uhutu.sportcenter.z.api.user;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.answer.z.entity.AwSettleAccount;
import com.uhutu.dcom.answer.z.service.AnswerServiceFactory;
import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.component.z.util.RandomUtil;
import com.uhutu.dcom.config.enums.SystemEnum;
import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.config.WechatConfig;
import com.uhutu.dcom.user.z.entity.UcSocialLogin;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput2;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult2;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;
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
public class ApiSocialLogin2 extends RootApiBase<ApiSocialLoginInput2, ApiSocialLoginResult2> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	@Autowired
	private AnswerServiceFactory answerServiceFactory;
	
	@Autowired
	private WechatConfig config;
	
	private UserCallFactory userCallFactory = new UserCallFactory();

	public ApiSocialLoginResult2 process(ApiSocialLoginInput2 inputParam) {
		
	    ApiSocialLoginResult2 result = new ApiSocialLoginResult2();
	    
	    if(StringUtils.isBlank(inputParam.getAccountName())){
	    	
	    	result.inError(81100017);
	    	
	    }
	    
		if(result.upFlagTrue()){
			
		    saveSocialLogin(inputParam);
		    
		    UserReginsterResult userRegResult = userRegister(inputParam.getAccountId());
		    
			if (userRegResult.upFlagTrue()) {

				saveUserInfo(userRegResult, inputParam);

				saveUserInfoExt(userRegResult.getUserCode(), inputParam);

				saveSocialInfo(userRegResult.getUserCode(), inputParam);
				
				/*关注官方帐号*/
				userServiceFactory.getUserInfoService().attendOffice(userRegResult.getUserCode());

				result.setFirstLogin(true);

				result.setUserToken(userRegResult.getToken());

				result.setUserCode(userRegResult.getUserCode());

			}else{
		    	
		    	result = loginSytem(inputParam.getAccountId());
		    	
		    }
		    
		    if(StringUtils.equals(inputParam.getAccountType(), "wechat") || StringUtils.equals(inputParam.getAccountType(), "wechat_h5")){
		    	
		    	 bindSettleAccount(result.getUserCode(), inputParam.getAccountName(),inputParam.getAccountType(), inputParam.getOpenid(), inputParam.getAccountId());
		    	
		    }
			
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
	public UcUserinfo saveUserInfo(UserReginsterResult userRegResult,ApiSocialLoginInput2 input){
		
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
			
			ucUserinfo.setMjFlag(SystemEnum.NO.getCode());
			
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
	public void saveUserInfoExt(String userCode,ApiSocialLoginInput2 input){
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
		
		if(ucUserinfoExt == null){
			
			ucUserinfoExt = new UcUserinfoExt();
			
			String accountName = EmojiUtil.emojiFilter(input.getAccountName());
			
			String nickName = initNickName(accountName, userCode);
	
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
	public void saveSocialInfo(String userCode, ApiSocialLoginInput2 input){
		
		UcUserinfoSocial social = userServiceFactory.getUserInfoSocialService().queryByUserCode(userCode);
		
		if(social == null){
			
			social = new UcUserinfoSocial();
			
			social.setAccountId(input.getAccountId());
			
			String accountName = EmojiUtil.emojiFilter(input.getAccountName());
			
			social.setAccountName(accountName);
			
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
		
		UcUserinfoExt ucUserinfoExt = JdbcHelper.queryOne(UcUserinfoExt.class, "nickName",nickName);
		
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
	public ApiSocialLoginResult2 loginSytem(String openId){
		
		ApiSocialLoginResult2 loginResult = new ApiSocialLoginResult2();
		
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
	
	/**
	 * 用户登录信息
	 * @param input
	 */
	public void saveSocialLogin(ApiSocialLoginInput2 input){
		
		UcSocialLogin ucSocialLogin = userServiceFactory.getUserSocialLoginService().queryByUnionId(input.getAccountType(),input.getAccountId());
		
		if(ucSocialLogin == null){
			
			ucSocialLogin = new UcSocialLogin();
			
			ucSocialLogin.setOpenid(input.getOpenid());
			
			if(StringUtils.isBlank(input.getOpenid())){
				
				ucSocialLogin.setOpenid(input.getAccountId());
				
			}
			
			ucSocialLogin.setUnionid(input.getAccountId());
			
			ucSocialLogin.setType(input.getAccountType());
			
			userServiceFactory.getUserSocialLoginService().save(ucSocialLogin);
			
		}else{
			
			ucSocialLogin.setOpenid(input.getOpenid());
			
			userServiceFactory.getUserSocialLoginService().save(ucSocialLogin);
			
		}
		
	}
	
	public void bindSettleAccount(String userCode,String accountName,String accountType,String openid,String unionid) {

		AwSettleAccount settleAccount = answerServiceFactory.getSettleAccountService().queryByUserCode(userCode);

		if (settleAccount == null) {

			settleAccount = new AwSettleAccount();
			
			PayProcessEnum processEnum = PayProcessEnum.WECHAT;
			
			if(StringUtils.equals(accountType, "wechat_h5")){
				
				processEnum = PayProcessEnum.WECHAT_H5;
				
			}

			settleAccount.setAppid(config.getAppId(processEnum));

			settleAccount.setOpenid(openid);

			settleAccount.setStatus(SystemEnum.YES.getCode());

			settleAccount.setType("wechat");
			
			if(StringUtils.isNotBlank(accountName)){
				
				accountName = EmojiUtil.emojiFilter(accountName);
				
			}
			
			settleAccount.setAccountName(accountName);

			settleAccount.setUnionid(unionid);

			settleAccount.setUserCode(userCode);

			answerServiceFactory.getSettleAccountService().save(settleAccount);

		}

	}
	

}
