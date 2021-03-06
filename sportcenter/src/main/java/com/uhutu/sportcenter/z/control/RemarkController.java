package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiOperRemarkInput;
import com.uhutu.sportcenter.z.input.ApiPublishRemarkInput;
import com.uhutu.sportcenter.z.input.ApiRemarkCountInput;
import com.uhutu.sportcenter.z.input.ApiRemarkListInput;
import com.uhutu.sportcenter.z.result.ApiOperRemarkResult;
import com.uhutu.sportcenter.z.result.ApiPublishRemarkResult;
import com.uhutu.sportcenter.z.result.ApiRemarkCountResult;
import com.uhutu.sportcenter.z.result.ApiRemarkListResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 评论相关控制器
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/remarkController")
@Api(tags = "评论相关接口")
public class RemarkController {
	
	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/publicRemark", method = RequestMethod.POST)
	@ApiOperation(value = "发布评论", notes = "发布评论")
	public ApiPublishRemarkResult publicRemark(@RequestBody ApiPublishRemarkInput input) {

		return apiFactory.getApiPublishRemark().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remarkList", method = RequestMethod.POST)
	@ApiOperation(value = "评论信息列表", notes = "评论信息列表")
	public ApiRemarkListResult remarkList(@RequestBody ApiRemarkListInput input) {

		return apiFactory.getApiRemarkList().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remarkCount", method = RequestMethod.POST)
	@ApiOperation(value = "各种评论数", notes = "系统中各种数量展示")
	public ApiRemarkCountResult remarkCount(@RequestBody ApiRemarkCountInput input) {

		return apiFactory.getApiRemarkCount().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/operRemark", method = RequestMethod.POST)
	@ApiOperation(value = "评论相关操作", notes = "评论相关操作")
	public ApiOperRemarkResult operRemark(@RequestBody ApiOperRemarkInput input) {

		return apiFactory.getApiOperRemark().api(input);
	}

}
