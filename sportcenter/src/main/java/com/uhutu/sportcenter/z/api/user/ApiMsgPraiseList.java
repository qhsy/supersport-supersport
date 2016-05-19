package com.uhutu.sportcenter.z.api.user;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiMsgPraiseListInput;
import com.uhutu.sportcenter.z.result.ApiMsgPraiseListResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 点赞通知消息列表
 * @author 逄小帅
 *
 */
@Component
public class ApiMsgPraiseList extends RootApiToken<ApiMsgPraiseListInput, ApiMsgPraiseListResult> {

	@Override
	protected ApiMsgPraiseListResult process(ApiMsgPraiseListInput input) {
		
		return new ApiMsgPraiseListResult();
		
	}

}
