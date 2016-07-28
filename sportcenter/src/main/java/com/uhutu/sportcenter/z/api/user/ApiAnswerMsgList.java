package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiAnswerMsgListInput;
import com.uhutu.sportcenter.z.result.ApiAnswerMsgListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiAnswerMsgList extends RootApiToken<ApiAnswerMsgListInput, ApiAnswerMsgListResult> {
	

	@Override
	protected ApiAnswerMsgListResult process(ApiAnswerMsgListInput input) {
		
		ApiAnswerMsgListResult result = new ApiAnswerMsgListResult();
		
		return result;		
		
	}
	
	
}
