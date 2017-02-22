package com.uhutu.sportcenter.z.api.live2;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.support.LiveSupport;
import com.uhutu.sportcenter.z.input.ApiLiveEnterGroupInput;
import com.uhutu.sportcenter.z.result.ApiLiveEnterGroupResult;
import com.uhutu.zoocom.root.RootApiToken;

@Component
public class ApiLiveEnterGroup extends RootApiToken<ApiLiveEnterGroupInput, ApiLiveEnterGroupResult> {

	@Override
	protected ApiLiveEnterGroupResult process(ApiLiveEnterGroupInput input) {
		
		ApiLiveEnterGroupResult result = new ApiLiveEnterGroupResult();
		
		/*0增加*/
		LiveSupport.getInstance().operLiveCount(input.getFlag(), 0, input.getUserCode(), "watch",input.getGroupId());
		
		return result;
	}
	

}
