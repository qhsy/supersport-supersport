package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.dcom.pay.z.request.WechatConfigRequest;
import com.uhutu.dcom.pay.z.response.WechatConfigResponse;
import com.uhutu.sportcenter.z.input.ApiWechatConfigInfoInput;
import com.uhutu.sportcenter.z.result.ApiWechatConfigInfoResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 微信配置信息
 * @author 逄小帅
 *
 */
@Component
public class ApiWechatConfigInfo extends RootApiBase<ApiWechatConfigInfoInput, ApiWechatConfigInfoResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiWechatConfigInfoResult process(ApiWechatConfigInfoInput input) {
		
		ApiWechatConfigInfoResult configInfoResult = new ApiWechatConfigInfoResult();

		WechatConfigRequest configRequest = new WechatConfigRequest();

		configRequest.setUrl(input.getUrl());

		WechatConfigResponse configResponse = (WechatConfigResponse) payGateProcess
				.process(PayProcessEnum.WECHAT_SERVICE_CONFIG, configRequest, new MDataMap());
		
		BeanUtils.copyProperties(configResponse, configInfoResult);

		return configInfoResult;
	}

}
