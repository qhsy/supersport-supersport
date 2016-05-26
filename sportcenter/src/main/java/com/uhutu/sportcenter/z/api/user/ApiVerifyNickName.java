package com.uhutu.sportcenter.z.api.user;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiVerifyNickNameInput;
import com.uhutu.sportcenter.z.result.ApiVerifyNickNameResult;
import com.uhutu.zoocom.define.DefineUser;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.z.bean.TopUserFactory;

/**
 * 昵称校验
 * @author 逄小帅
 *
 */
@Component
public class ApiVerifyNickName extends RootApiBase<ApiVerifyNickNameInput, ApiVerifyNickNameResult> {

	@Autowired
	private UserServiceFactory serviceFacotry;
	
	@Override
	protected ApiVerifyNickNameResult process(ApiVerifyNickNameInput input) {
		
		ApiVerifyNickNameResult result = new ApiVerifyNickNameResult();
		
		UcUserinfoExt ucUserinfoExt = serviceFacotry.getUserInfoExtService().queryByNickName(input.getNickName());
		
		if(ucUserinfoExt != null){
			
			String userCode = TopUserFactory.upUserCallFactory().upUserCodeByAuthToken(input.getZoo().getToken(), DefineUser.Login_System_Default);
			
			if(StringUtils.equals(userCode, ucUserinfoExt.getUserCode())){
				
				result.inError(81100001);
				
			}
			
		}
		
		return result;
	}

}
