package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiLiveCreateRoomInput;
import com.uhutu.sportcenter.z.result.ApiLiveCreateRoomResult;

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

}
