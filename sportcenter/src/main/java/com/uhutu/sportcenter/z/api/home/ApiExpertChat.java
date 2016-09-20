package com.uhutu.sportcenter.z.api.home;

import org.springframework.stereotype.Component;
import com.uhutu.sportcenter.z.input.ApiExpertChatInput;
import com.uhutu.sportcenter.z.result.ApiExpertChatResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 达人专访
 * @author 逄小帅
 *
 */
@Component
public class ApiExpertChat extends RootApiBase<ApiExpertChatInput, ApiExpertChatResult> {

	@Override
	protected ApiExpertChatResult process(ApiExpertChatInput input) {
		
		ApiExpertChatResult chatResult = new ApiExpertChatResult();
		
		return chatResult;
	}
	

}
