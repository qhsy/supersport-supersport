package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.pay.z.common.PayProcessEnum;
import com.uhutu.dcom.pay.z.process.impl.PayGateProcess;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 微信h5支付
 * @author 逄小帅
 *
 */
public class ApiWechatH5Pay extends RootApiToken<ApiWechatH5PayInput, ApiWechatH5PayResult> {
	
	@Autowired
	private PayGateProcess payGateProcess;

	@Override
	protected ApiWechatH5PayResult process(ApiWechatH5PayInput input) {
		
		return null;
	}

}
