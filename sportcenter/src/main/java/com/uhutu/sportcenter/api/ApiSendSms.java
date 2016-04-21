package com.uhutu.sportcenter.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.input.ApiSendSmsInput;
import com.uhutu.sportcenter.api.result.ApiSendSmsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 短信发送接口
 * @author pang_jhui
 *
 */
@Service
public class ApiSendSms extends RootApiBase< ApiSendSmsInput,ApiSendSmsResult> {
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiSendSmsResult process(ApiSendSmsInput inputParam ) {
		
		ApiSendSmsResult sendSmsResult = new ApiSendSmsResult();
		
		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(inputParam.getMobileNO());
		
		if(ucUserinfo != null){
			
			sendSmsResult.setError("该用户已经注册");
			
			sendSmsResult.setStatus(0);
			
		}
		
		return sendSmsResult;
	}

}
