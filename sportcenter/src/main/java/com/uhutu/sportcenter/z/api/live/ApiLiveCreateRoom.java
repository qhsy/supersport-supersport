package com.uhutu.sportcenter.z.api.live;

import org.springframework.stereotype.Component;

import com.uhutu.sportcenter.z.input.ApiLiveCreateRoomInput;
import com.uhutu.sportcenter.z.result.ApiLiveCreateRoomResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 创建房间
 * 
 * @author xiegj
 *
 */
@Component
public class ApiLiveCreateRoom extends RootApiToken<ApiLiveCreateRoomInput, ApiLiveCreateRoomResult> {

	@Override
	protected ApiLiveCreateRoomResult process(ApiLiveCreateRoomInput input) {

		ApiLiveCreateRoomResult result = new ApiLiveCreateRoomResult();

		return result;

	}

}
