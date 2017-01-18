package com.uhutu.dcom.user.z.support;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.z.entity.UserBasicInfo;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.zoocom.helper.MapHelper;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.z.entity.ZwLoginInfo;

/**
 * 用户信息统一支撑类
 * @author pang_jhui
 *
 */
@Component
public class UserInfoSupport {
	
	@Autowired
	private UserServiceFactory userServiceFactory;
	
	/**
	 * 根据用户编号获取用户基本信息
	 * @param userCode
	 * 		用户编号
	 * @return 用户基本信息
	 */
	public UserBasicInfo getUserBasicInfo(String userCode) {

		UserBasicInfo userBasicInfo = new UserBasicInfo();
		
		userBasicInfo.setUcUserinfo(getUserInfo(userCode));
		
		userBasicInfo.setUcUserinfoExt(getUserInfoExt(userCode));
		
		userBasicInfo.setUcUserinfoSocial(getUserInfoSocial(userCode));
		
		return userBasicInfo;

	}
	
	/**
	 * 获取用户信息
	 * @param userCode
	 * 		用户编号
	 * @return 用户信息
	 */
	public UcUserinfo getUserInfo(String userCode){
		
		return userServiceFactory.getUserInfoService().queryByCode(userCode);
		
	}
	
	/**
	 * 用户扩展信息
	 * @param userCode
	 * 		用户编号
	 * @return 用户扩展信息
	 */
	public UcUserinfoExt getUserInfoExt(String userCode){
		
		return userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
		
	}
	
	/**
	 * 用户社交信息
	 * @param userCode
	 * 		用户编号
	 * @return 用户社交信息
	 */
	public UcUserinfoSocial getUserInfoSocial(String userCode){
		
		return userServiceFactory.getUserInfoSocialService().queryByUserCode(userCode);
		
	}
	
	/**
	 * 用户注册
	 * @param userinfo
	 * 		用户信息
	 * @param userinfoExt
	 * 		用户扩展信息
	 * @param userinfoSocial
	 * 		社交用户登录
	 */
	public String regUser(UcUserinfo userinfo, UcUserinfoExt userinfoExt, UcUserinfoSocial userinfoSocial){
		
		synchronized (UserInfoSupport.class) {
			
			String returnStr = "";
			
			
			if(userinfoExt != null){				

				try {
					
					UcUserinfoExt nickNameInfo = JdbcHelper.queryOne(UcUserinfoExt.class, "nickName",userinfoExt.getNickName());
					
					if(nickNameInfo == null){
						
						userServiceFactory.getUserInfoExtService().save(userinfoExt);
						
					}else{
						
						returnStr = "昵称已经被占用，请更换昵称";
						
					}
					
				} catch (Exception e) {
					
					returnStr = e.getMessage();
					
				}
				
			}
			
			if(StringUtils.isEmpty(returnStr)){
				
				if(userinfo != null){
					
					userServiceFactory.getUserInfoService().save(userinfo);
					
				}
				
				if(userinfoSocial != null){
					
					userServiceFactory.getUserInfoSocialService().save(userinfoSocial);
					
				}
				
			}else{
				
				ZwLoginInfo zwLoginInfo = JdbcHelper.queryOne(ZwLoginInfo.class, "loginName",userinfo.getLoginName());
				
				if(zwLoginInfo != null){
					
					JdbcHelper.dataDelete("zw_login_info", MapHelper.initMap("loginName",userinfo.getLoginName()));
					
				}
				
			}
			
			return returnStr;
			
		}
		
	}

	public UserServiceFactory getUserServiceFactory() {
		return userServiceFactory;
	}

}
