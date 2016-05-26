package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;
import com.uhutu.sportcenter.z.input.ApiMsgAdviceInput;
import com.uhutu.sportcenter.z.result.ApiMsgAdviceResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 意见投诉
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgAdvice extends RootApiToken<ApiMsgAdviceInput, ApiMsgAdviceResult> {

	@Override
	protected ApiMsgAdviceResult process(ApiMsgAdviceInput input) {
		
		ApiMsgAdviceResult result = new ApiMsgAdviceResult();
		
		return result;
		
	}

}
