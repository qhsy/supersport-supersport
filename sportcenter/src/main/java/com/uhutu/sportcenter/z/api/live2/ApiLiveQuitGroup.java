package com.uhutu.sportcenter.z.api.live2;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.sportcenter.z.input.ApiLiveQuitGroupInput;
import com.uhutu.sportcenter.z.result.ApiLiveQuitGroupResult;
import com.uhutu.zoocom.root.RootApiToken;

@Component
public class ApiLiveQuitGroup extends RootApiToken<ApiLiveQuitGroupInput, ApiLiveQuitGroupResult> {

	@Override
	protected ApiLiveQuitGroupResult process(ApiLiveQuitGroupInput input) {
		
		ApiLiveQuitGroupResult result = new ApiLiveQuitGroupResult();
		
		/*0增加 1减少*/
		LiveSupport.getInstance().operLiveCount(input.getFlag(), 1, input.getUserCode(), "watch",input.getGroupId());
		
		return result;
	}

}
