package com.uhutu.sportcenter.z.api.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.response.WechatAccessTokenResponse;
import com.uhutu.sportcenter.z.input.ApiSaveWechatVoiceInput;
import com.uhutu.sportcenter.z.result.ApiSaveWechatVoiceResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 获取微信语音信息
 * 
 * @author xiegj
 *
 */
@Component
public class ApiSaveWechatVoice extends RootApiToken<ApiSaveWechatVoiceInput, ApiSaveWechatVoiceResult> {

	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiSaveWechatVoiceResult process(ApiSaveWechatVoiceInput input) {

		ApiSaveWechatVoiceResult result = new ApiSaveWechatVoiceResult();
		WechatAccessTokenResponse tokenResponse = (WechatAccessTokenResponse) payGateProcess.process(PayProcessEnum.WECHAT_TOKEN, null, new MDataMap());

		System.out.println(tokenResponse.getAccess_token()+"***"+tokenResponse.getErrcode()+"***"+tokenResponse.getErrmsg()+"***"+tokenResponse.getExpires_in());

		return result;

	}

}
