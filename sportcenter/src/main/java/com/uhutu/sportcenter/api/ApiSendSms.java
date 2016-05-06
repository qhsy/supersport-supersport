package com.uhutu.sportcenter.api;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.sms.SmsSupport;
import com.uhutu.dcom.component.sms.SmsTypeEnum;
import com.uhutu.dcom.user.entity.UcUserinfo;
import com.uhutu.dcom.user.enums.UserOperEnum;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.input.ApiSendSmsInput;
import com.uhutu.sportcenter.api.result.ApiSendSmsResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoocom.root.RootApiResult;

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
		
		if(ucUserinfo != null && StringUtils.equals(inputParam.getMsgType(), UserOperEnum.register.name())){
			
			sendSmsResult.setError("该用户已经注册");
			sendSmsResult.setStatus(0);
		}else {
			RootApiResult rr = new RootApiResult();
			if("register".equals(inputParam.getMsgType())){
				rr = new SmsSupport().sendVerifyCode(new SmsSupport().smsTypeByEnumer(SmsTypeEnum.register), inputParam.getMobileNO(), 6, 5);
			}else if ("login".equals(inputParam.getMsgType())) {
				rr = new SmsSupport().sendVerifyCode(new SmsSupport().smsTypeByEnumer(SmsTypeEnum.login), inputParam.getMobileNO(), 6, 5);
			}else if ("resetpwd".equals(inputParam.getMsgType())) {
				rr = new SmsSupport().sendVerifyCode(new SmsSupport().smsTypeByEnumer(SmsTypeEnum.resetpwd), inputParam.getMobileNO(), 6, 5);
			}else if ("forgetpwd".equals(inputParam.getMsgType())) {
				rr = new SmsSupport().sendVerifyCode(new SmsSupport().smsTypeByEnumer(SmsTypeEnum.forgetpwd), inputParam.getMobileNO(), 6, 5);
			}else {
				sendSmsResult.setStatus(0);
			}
			sendSmsResult.setStatus(rr.getStatus());
			sendSmsResult.setError("无此验证码类型");
		}
		
		return sendSmsResult;
	}

}
