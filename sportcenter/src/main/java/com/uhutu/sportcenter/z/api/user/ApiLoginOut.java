package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Service;
import com.uhutu.sportcenter.z.input.ApiLoginOutInput;
import com.uhutu.sportcenter.z.result.ApiLoginOutResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zooweb.user.UserCallFactory;

/**
 * 用户信息退出
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiLoginOut extends RootApiToken<ApiLoginOutInput, ApiLoginOutResult> {

	public ApiLoginOutResult process(ApiLoginOutInput inputParam) {

		ApiLoginOutResult result = new ApiLoginOutResult();

		UserCallFactory userCallFactory = new UserCallFactory();
		
		boolean flag = userCallFactory.userLogout(inputParam.getZoo().getToken());
		
		if(!flag){
			
			result.inError(81100004);
			
		}

		return result;

	}

}
