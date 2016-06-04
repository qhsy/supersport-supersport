package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiMsgAdviceInput;
import com.uhutu.sportcenter.z.input.ApiMsgAttendListInput;
import com.uhutu.sportcenter.z.input.ApiMsgNoticeListInput;
import com.uhutu.sportcenter.z.input.ApiMsgNumListInput;
import com.uhutu.sportcenter.z.input.ApiMsgPraiseListInput;
import com.uhutu.sportcenter.z.input.ApiMsgRemarkListInput;
import com.uhutu.sportcenter.z.input.ApiUpdateMsgStatusInput;
import com.uhutu.sportcenter.z.result.ApiMsgAdviceResult;
import com.uhutu.sportcenter.z.result.ApiMsgAttendListResult;
import com.uhutu.sportcenter.z.result.ApiMsgNoticeListResult;
import com.uhutu.sportcenter.z.result.ApiMsgNumListResult;
import com.uhutu.sportcenter.z.result.ApiMsgPraiseListResult;
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
public class UserMsgController {
	
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
	
	@ResponseBody
	@RequestMapping(value = "/msgPraiseList", method = RequestMethod.POST)
	@ApiOperation(value = "消息点赞列表", notes = "用户消息中心")
	public ApiMsgPraiseListResult msgPraiseList(@RequestBody ApiMsgPraiseListInput input) {

		return apiFactory.getApiMsgPraiseList().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/msgAttendList", method = RequestMethod.POST)
	@ApiOperation(value = "消息关注列表", notes = "用户消息中心")
	public ApiMsgAttendListResult msgAttendList(@RequestBody ApiMsgAttendListInput input) {

		return apiFactory.getApiMsgAttendList().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/msgNoticeList", method = RequestMethod.POST)
	@ApiOperation(value = "消息通知列表", notes = "用户消息中心")
	public ApiMsgNoticeListResult msgNoticeList(@RequestBody ApiMsgNoticeListInput input) {

		return apiFactory.getApiMsgNoticeList().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/msgAdvice", method = RequestMethod.POST)
	@ApiOperation(value = "意见反馈", notes = "用户中心")
	public ApiMsgAdviceResult msgAdvice(@RequestBody ApiMsgAdviceInput input) {

		return apiFactory.getApiMsgAdvice().api(input);

	}
	
	

}
