package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiCheckSingTypeInput;
import com.uhutu.sportcenter.z.input.ApiForAnswerOrderInput;
import com.uhutu.sportcenter.z.input.ApiSignPhotoInput;
import com.uhutu.sportcenter.z.result.ApiCheckSingTypeResult;
import com.uhutu.sportcenter.z.result.ApiForAnswerOrderResult;
import com.uhutu.sportcenter.z.result.ApiSignPhotoResult;

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
	public ApiForAnswerOrderResult versionInfo(@RequestBody ApiForAnswerOrderInput input, HttpServletRequest request) {
		String[] paths = request.getRequestURL().toString().split("/");
		String path = paths[0] + "//" + paths[2];
		input.setServeIP(path);
		input.setRomoteIP(request.getRemoteAddr());
		return apiFactory.getApiForAnswerOrder().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/checkSingType", method = RequestMethod.POST)
	@ApiOperation(value = "校验可报名组别", notes = "校验可报名组别")
	public ApiCheckSingTypeResult checkSingType(@RequestBody ApiCheckSingTypeInput input, HttpServletRequest request) {
		return apiFactory.getApiCheckSingType().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/signPhoto", method = RequestMethod.POST)
	@ApiOperation(value = "报名证件", notes = "报名证件")
	public ApiSignPhotoResult signPhoto(@RequestBody ApiSignPhotoInput input, HttpServletRequest request) {
		return apiFactory.getApiSignPhoto().api(input);
	}

}
