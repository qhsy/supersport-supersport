package com.uhutu.sportcenter.z.api.pay;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiCoinAccInfoInput;
import com.uhutu.sportcenter.z.result.ApiCoinAccInfoResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 金币账户信息
 * @author 逄小帅
 *
 */
@Component
public class ApiCoinAccInfo extends RootApiToken<ApiCoinAccInfoInput, ApiCoinAccInfoResult> {

	@Override
	protected ApiCoinAccInfoResult process(ApiCoinAccInfoInput input) {
		
		ApiCoinAccInfoResult coinAccInfoResult = new ApiCoinAccInfoResult();
		
		return coinAccInfoResult;
	}

}
