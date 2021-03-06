package com.uhutu.sportcenter.z.api.extend;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.dcom.extend.sms.SmsSupport;
import com.uhutu.dcom.extend.sms.SmsTypeEnum;
import com.uhutu.dcom.user.z.entity.UcUserinfo;
import com.uhutu.dcom.user.z.enums.UserEnum;
import com.uhutu.dcom.user.z.enums.UserOperEnum;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSendSmsInput;
import com.uhutu.sportcenter.z.result.ApiSendSmsResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 短信发送接口
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiSendSms extends RootApiBase<ApiSendSmsInput, ApiSendSmsResult> {

	@Autowired
	private UserServiceFactory userServiceFactory;

	public ApiSendSmsResult process(ApiSendSmsInput inputParam) {

		ApiSendSmsResult sendSmsResult = new ApiSendSmsResult();

		UcUserinfo ucUserinfo = userServiceFactory.getUserInfoService().queryByLoginName(inputParam.getMobileNO(),UserEnum.FLAG_ENABLE.getCode());

		if (ucUserinfo != null && StringUtils.equals(inputParam.getMsgType(), UserOperEnum.register.name())) {

			sendSmsResult.setError("该用户已经注册");
			sendSmsResult.setStatus(0);
		} else {
			RootApiResult rr = new RootApiResult();
			if ("register".equals(inputParam.getMsgType())) {
				rr = new SmsSupport("app.cloopen.com", "8a48b551544cd73f0154610f96b91815",
						"dd926d36f55741bab9d35207ee65df8b", "aaf98f89544cd9d90154611297fa1768", "89117").sendVerifyCode(
								new SmsSupport().smsTypeByEnumer(SmsTypeEnum.register), inputParam.getMobileNO(), 6, 5);
			} else if ("login".equals(inputParam.getMsgType())) {
				rr = new SmsSupport("app.cloopen.com", "8a48b551544cd73f0154610f96b91815",
						"dd926d36f55741bab9d35207ee65df8b", "aaf98f89544cd9d90154611297fa1768", "89117").sendVerifyCode(
								new SmsSupport().smsTypeByEnumer(SmsTypeEnum.login), inputParam.getMobileNO(), 6, 5);
			} else if ("resetpwd".equals(inputParam.getMsgType())) {
				rr = new SmsSupport("app.cloopen.com", "8a48b551544cd73f0154610f96b91815",
						"dd926d36f55741bab9d35207ee65df8b", "aaf98f89544cd9d90154611297fa1768", "89117").sendVerifyCode(
								new SmsSupport().smsTypeByEnumer(SmsTypeEnum.resetpwd), inputParam.getMobileNO(), 6, 5);
			} else if ("forgetpwd".equals(inputParam.getMsgType())) {
				rr = new SmsSupport("app.cloopen.com", "8a48b551544cd73f0154610f96b91815",
						"dd926d36f55741bab9d35207ee65df8b", "aaf98f89544cd9d90154611297fa1768", "89117").sendVerifyCode(
								new SmsSupport().smsTypeByEnumer(SmsTypeEnum.forgetpwd), inputParam.getMobileNO(), 6,
								5);
			} else {
				rr.setStatus(0);
				rr.setError("无此验证码类型");
			}
			sendSmsResult.setStatus(rr.getStatus());
			sendSmsResult.setError(rr.getError());
		}
		if (sendSmsResult.getStatus() == 81090003) {// 特俗处理：一分钟之内多次发送验证码的话直接返回成功
			sendSmsResult.setStatus(0);
			sendSmsResult.setError("");
		}
		return sendSmsResult;
	}

}
