package com.uhutu.sportcenter.z.api.donate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfoExpert;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiUserPowerShareInput;
import com.uhutu.sportcenter.z.result.ApiUserPowerShareResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 用户能量分享信息
 * @author pang_jhui
 *
 */
@Component
public class ApiUserPowerShare extends RootApiBase<ApiUserPowerShareInput, ApiUserPowerShareResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUserPowerShareResult process(ApiUserPowerShareInput input) {
		
		ApiUserPowerShareResult result = new ApiUserPowerShareResult();
		
		String path="/webjars/sportstatic/index/share.html";
		
		UcUserinfoExpert userInfoExpert = userServiceFactory.getUserInfoExpertService().queryByCode(input.getUserCode());
		
		if(userInfoExpert != null){
			
			result.setShareTitle(userInfoExpert.getShareTitle());
			
			result.setShareDesc(userInfoExpert.getShareDesc());
			
			result.setShareIcon(userInfoExpert.getShareIcon());
			
			String shareUrl = "http://"+input.getServerIp()+path+"?code="+input.getUserCode()+"&share=0";
				
			result.setShareUrl(shareUrl);
			
			
			
		}else{
			
			result.inError(81100003);
			
		}
		
		return result;
	}

	

}
