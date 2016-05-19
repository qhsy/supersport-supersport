package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiMsgNumListInput;
import com.uhutu.sportcenter.z.input.ApiMsgRemarkListInput;
import com.uhutu.sportcenter.z.input.ApiUpdateMsgStatusInput;
import com.uhutu.sportcenter.z.result.ApiMsgNumListResult;
import com.uhutu.sportcenter.z.result.ApiMsgRemarkResult;
import com.uhutu.sportcenter.z.result.ApiUpdateMsgStatusResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户消息中心相关控制器
 * 
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/userMsgController")
@Api(tags = "用户消息中心接口")
public class UserMsgContoller {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/userMsgNumInfo", method = RequestMethod.POST)
	@ApiOperation(value = "用户消息提醒数量", notes = "用户消息中心")
	public ApiMsgNumListResult userMsgNumInfo(@RequestBody ApiMsgNumListInput input) {

		return apiFactory.getApiMsgNumList().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/updateMsgStatus", method = RequestMethod.POST)
	@ApiOperation(value = "更新消息状态", notes = "用户消息中心")
	public ApiUpdateMsgStatusResult updateMsgStatus(@RequestBody ApiUpdateMsgStatusInput input) {

		return apiFactory.getApiUpdateMsgStatus().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/msgRemarkList", method = RequestMethod.POST)
	@ApiOperation(value = "消息中心评论列表", notes = "用户消息中心")
	public ApiMsgRemarkResult msgRemarkList(@RequestBody ApiMsgRemarkListInput input) {

		return apiFactory.getApiMsgRemarkList().api(input);

	}

}
