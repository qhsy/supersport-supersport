package com.uhutu.sportcenter.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.user.entity.UserBasicInfo;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.face.RootUserToken;
import com.uhutu.sportcenter.api.input.ApiSetUserFavoerInput;
import com.uhutu.sportcenter.api.result.ApiSetUserFavorResult;

/**
 * 设置用户喜欢运动
 * @author pang_jhui
 *
 */
public class ApiSetUserFavor extends RootUserToken<ApiSetUserFavoerInput, ApiSetUserFavorResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiSetUserFavorResult process(ApiSetUserFavoerInput input) {
		
		ApiSetUserFavorResult favorResult = new ApiSetUserFavorResult();
		
		UserBasicInfo userBasicInfo = getUserBasicInfo(input.getZoo().getToken());
		
		if(userBasicInfo == null){
			
			favorResult.setStatus(0);
			
			favorResult.setError("用户信息不存在");
			
			return favorResult;
			
		}else{
			
			userBasicInfo.getUcUserinfoExt().setAboutTag(input.getCatagoryCodes());
			
			userServiceFactory.getUserInfoExtService().save(userBasicInfo.getUcUserinfoExt());
			
		}
		
		return favorResult;
	}

}
