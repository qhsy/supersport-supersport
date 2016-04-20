package com.uhutu.sportcenter.api;

import org.springframework.stereotype.Service;

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

	public ApiSendSmsResult process(ApiSendSmsInput inputParam ) {
		
		return new ApiSendSmsResult();
	}

}
