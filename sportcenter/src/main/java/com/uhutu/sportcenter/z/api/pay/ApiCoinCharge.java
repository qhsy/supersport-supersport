package com.uhutu.sportcenter.z.api.pay;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiCoinChargeInput;
import com.uhutu.sportcenter.z.result.ApiCoinChargeResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 金币充值
 * @author 逄小帅
 *
 */
@Component
public class ApiCoinCharge extends RootApiToken<ApiCoinChargeInput, ApiCoinChargeResult> {

	@Override
	protected ApiCoinChargeResult process(ApiCoinChargeInput input) {
		
		ApiCoinChargeResult coinChargeResult = new ApiCoinChargeResult();
		
		return coinChargeResult;
	}

}
