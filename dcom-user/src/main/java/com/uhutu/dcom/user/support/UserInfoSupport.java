package com.uhutu.dcom.user.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.entity.UcUserinfoSocial;
import com.uhutu.dcom.user.entity.UserBasicInfo;
import com.uhutu.dcom.user.service.UserServiceFactory;

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

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByCode(userCode);

		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
		
		UcUserinfoSocial userinfoSocial = userServiceFactory.getUserInfoSocialService().queryByUserCode(userCode);
		
		userBasicInfo.setUcUserinfo(ucUserinfo);
		
		userBasicInfo.setUcUserinfoExt(ucUserinfoExt);
		
		userBasicInfo.setUcUserinfoSocial(userinfoSocial);
		
		return userBasicInfo;

	}

}
