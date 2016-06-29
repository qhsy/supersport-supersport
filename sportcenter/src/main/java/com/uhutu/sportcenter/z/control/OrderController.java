package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiForAnswerOrderInput;
import com.uhutu.sportcenter.z.result.ApiForAnswerOrderResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单相关接口
 * 
 * @author xiegj
 *
 */
@RestController
@RequestMapping(value = "/api/orderController")
@Api(tags = "订单相关接口")
public class OrderController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/answerOrder", method = RequestMethod.POST)
	@ApiOperation(value = "问答订单接口", notes = "问答订单创建")
	public ApiForAnswerOrderResult versionInfo(@RequestBody ApiForAnswerOrderInput input) {

		return apiFactory.getApiForAnswerOrder().api(input);
	}

}
