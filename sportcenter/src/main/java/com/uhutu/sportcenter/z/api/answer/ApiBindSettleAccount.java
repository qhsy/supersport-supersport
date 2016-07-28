package com.uhutu.sportcenter.z.api.answer;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiBindSettleAccountInput;
import com.uhutu.sportcenter.z.result.ApiBindSettleAccountResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 绑定结算账户
 * @author 逄小帅
 *
 */
@Component
public class ApiBindSettleAccount extends RootApiToken<ApiBindSettleAccountInput, ApiBindSettleAccountResult> {

	@Override
	protected ApiBindSettleAccountResult process(ApiBindSettleAccountInput input) {
		
		ApiBindSettleAccountResult result = new ApiBindSettleAccountResult();
		
		if(input.isBinding()){
			
			
			
		}
		
		return result;
	}

}
