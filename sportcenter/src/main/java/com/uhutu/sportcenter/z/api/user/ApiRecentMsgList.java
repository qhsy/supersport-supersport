package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiRecentMsgListInput;
import com.uhutu.sportcenter.z.result.ApiRecentMsgListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 最近的消息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiRecentMsgList extends RootApiToken<ApiRecentMsgListInput, ApiRecentMsgListResult> {

	@Override
	protected ApiRecentMsgListResult process(ApiRecentMsgListInput input) {
		
		ApiRecentMsgListResult recentMsgListResult = new ApiRecentMsgListResult();
		
		return recentMsgListResult;
	}

}
