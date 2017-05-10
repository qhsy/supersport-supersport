package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiBeginLiveInput;
import com.uhutu.sportcenter.z.input.ApiChangeCountInput;
import com.uhutu.sportcenter.z.input.ApiChangeStatusInput;
import com.uhutu.sportcenter.z.input.ApiConvertStreamUrlInput;
import com.uhutu.sportcenter.z.input.ApiLiveEnterGroupInput;
import com.uhutu.sportcenter.z.input.ApiLiveQuitGroupInput;
import com.uhutu.sportcenter.z.result.ApiBeginLiveResult;
import com.uhutu.sportcenter.z.result.ApiChangeCountResult;
import com.uhutu.sportcenter.z.result.ApiChangeStatusResult;
import com.uhutu.sportcenter.z.result.ApiConvertStreamUrlResult;
import com.uhutu.sportcenter.z.result.ApiLiveEnterGroupResult;
import com.uhutu.sportcenter.z.result.ApiLiveQuitGroupResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 直播相关接口
 * 
 * @author 逄小帅
 *
 */
//@RestController
//@RequestMapping(value = "/api/liveNewController")
//@Api(tags = "新直播相关")
public class LiveNewController {

	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/beginLive", method = RequestMethod.POST)
	@ApiOperation(value = "开始直播", notes = "开始直播")
	public ApiBeginLiveResult beginLive(@RequestBody ApiBeginLiveInput input) {

		return apiFactory.getApiBeginLive().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/changeCount", method = RequestMethod.POST)
	@ApiOperation(value = "修改计数器", notes = "修改计数器")
	public ApiChangeCountResult changeCount(@RequestBody ApiChangeCountInput input) {

		return apiFactory.getApiChangeCount().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/quitGroup", method = RequestMethod.POST)
	@ApiOperation(value = "退出聊天室", notes = "退出聊天室")
	public ApiLiveQuitGroupResult quitGroup(@RequestBody ApiLiveQuitGroupInput input) {

		return apiFactory.getApiLiveQuitGroup().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/enterGroup", method = RequestMethod.POST)
	@ApiOperation(value = "进入聊天室", notes = "进入聊天室")
	public ApiLiveEnterGroupResult quitGroup(@RequestBody ApiLiveEnterGroupInput input) {

		return apiFactory.getApiLiveEnterGroup().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/changeStatus", method = RequestMethod.POST)
	@ApiOperation(value = "修改在线状态", notes = "修改在线状态")
	public ApiChangeStatusResult changeStatus(@RequestBody  ApiChangeStatusInput input) {

		return apiFactory.getApiChangeStatus().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getStreamUrl", method = RequestMethod.POST)
	@ApiOperation(value = "获取流地址", notes = "获取流地址")
	public ApiConvertStreamUrlResult changeStatus(@RequestBody  ApiConvertStreamUrlInput input) {

		return apiFactory.getApiConvertStreamUrl().api(input);
		
	}

}
