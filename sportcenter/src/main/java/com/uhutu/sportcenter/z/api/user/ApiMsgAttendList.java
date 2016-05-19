package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMsgAttendListInput;
import com.uhutu.sportcenter.z.result.ApiMsgAttendListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 关注消息通知列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgAttendList extends RootApiToken<ApiMsgAttendListInput, ApiMsgAttendListResult> {

	@Override
	protected ApiMsgAttendListResult process(ApiMsgAttendListInput input) {
		
		return new ApiMsgAttendListResult();
	}

}
