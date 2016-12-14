package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.user.z.entity.UcAccountInfo;
import com.uhutu.dcom.user.z.support.AccountComponet;
import com.uhutu.sportcenter.z.input.ApiWalletInfoInput;
import com.uhutu.sportcenter.z.result.ApiWalletInfoResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 钱包信息
 * @author 逄小帅
 *
 */
@Component
public class ApiWalletInfo extends RootApiToken<ApiWalletInfoInput, ApiWalletInfoResult> {

	@Override
	protected ApiWalletInfoResult process(ApiWalletInfoInput input) {
		
		ApiWalletInfoResult walletInfoResult = new ApiWalletInfoResult();
		
		UcAccountInfo accountInfo = AccountComponet.getInstance().getAccountInfo(upUserCode());
		
		if(accountInfo != null){
			
			walletInfoResult.getWalletInfo().setProfit(accountInfo.getProfit());
			
		}
		
		return walletInfoResult;
	}
	
	

}
