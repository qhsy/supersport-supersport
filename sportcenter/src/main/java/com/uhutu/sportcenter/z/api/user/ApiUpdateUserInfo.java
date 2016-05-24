package com.uhutu.sportcenter.z.api.user;

import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.UserInfo;
import com.uhutu.sportcenter.z.input.ApiUpdateUserInfoInput;
import com.uhutu.sportcenter.z.result.ApiUpdateUserInfoResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 更新用户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiUpdateUserInfo extends RootApiToken<ApiUpdateUserInfoInput, ApiUpdateUserInfoResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiUpdateUserInfoResult process(ApiUpdateUserInfoInput input) {
		
		ApiUpdateUserInfoResult result = new ApiUpdateUserInfoResult();
		
		Optional<UserInfo> userOption = Optional.ofNullable(input.getUserInfo());
		
		if(userOption.isPresent()){
			
			String userCode = input.getZoo().getToken();
			
			UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(userCode);
			
			Optional<UcUserinfoExt> userInfoExtOptional = Optional.ofNullable(ucUserinfoExt);
			
			if(userInfoExtOptional.isPresent()){
				
				BeanUtils.copyProperties(input.getUserInfo(), ucUserinfoExt);
				
				userServiceFactory.getUserInfoExtService().save(ucUserinfoExt);
				
			}else{
				
				result.setStatus(0);
				
				result.setError("用户信息不存在");
				
			}
			
			
			
		}else{
			
			result.setStatus(0);
			
			result.setError("用户信息为空");
			
		}
		
		return result;
	}

}
