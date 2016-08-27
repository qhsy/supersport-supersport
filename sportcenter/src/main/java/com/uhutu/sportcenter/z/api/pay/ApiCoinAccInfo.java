package com.uhutu.sportcenter.z.api.pay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.entity.PaCoinInfo;
import com.uhutu.dcom.pay.z.service.IPaCoinInfoService;
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
	
	@Autowired
	private IPaCoinInfoService paCoinInfoService;

	@Override
	protected ApiCoinAccInfoResult process(ApiCoinAccInfoInput input) {
		
		ApiCoinAccInfoResult coinAccInfoResult = new ApiCoinAccInfoResult();
		
		PaCoinInfo coinInfo = paCoinInfoService.queryByUserCode(upUserCode());
		
		if(coinInfo != null){
			
			coinAccInfoResult.setCoinNum(coinInfo.getBalance());
			
		}
		
		return coinAccInfoResult;
	}

}
