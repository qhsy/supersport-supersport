package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiFinishLiveVideoInput;
import com.uhutu.sportcenter.z.input.ApiLiveCreateRoomInput;
import com.uhutu.sportcenter.z.input.ApiLiveInfoListInput;
import com.uhutu.sportcenter.z.result.ApiFinishLiveVideoResult;
import com.uhutu.sportcenter.z.result.ApiLiveCreateRoomResult;
import com.uhutu.sportcenter.z.result.ApiLiveInfoListResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 直播相关接口
 * 
 * @author xiegj
 *
 */
@RestController
@RequestMapping(value = "/api/liveVideoController")
@Api(tags = "直播相关")
public class LiveVideoController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/liveCreateRoom", method = RequestMethod.POST)
	@ApiOperation(value = "创建房间", notes = "创建房间")
	public ApiLiveCreateRoomResult liveCreateRoom(@RequestBody ApiLiveCreateRoomInput input) {

		return apiFactory.getApiLiveCreateRoom().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/finishLiveVideo", method = RequestMethod.POST)
	@ApiOperation(value = "结束直播", notes = "结束直播")
	public ApiFinishLiveVideoResult finishLiveVideo(@RequestBody ApiFinishLiveVideoInput input) {

		return apiFactory.getApiFinishLiveVideo().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/liveViedos", method = RequestMethod.POST)
	@ApiOperation(value = "直播视频列表", notes = "直播视频列表")
	public ApiLiveInfoListResult liveViedos(@RequestBody ApiLiveInfoListInput input) {

		return apiFactory.getApiLiveInfoList().api(input);

	}

}
