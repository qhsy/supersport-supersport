package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiExpertChatInput;
import com.uhutu.sportcenter.z.input.ApiHotTopicInput;
import com.uhutu.sportcenter.z.input.ApiWonderfulVideoInput;
import com.uhutu.sportcenter.z.result.ApiExpertChatResult;
import com.uhutu.sportcenter.z.result.ApiHotTopicResult;
import com.uhutu.sportcenter.z.result.ApiWonderfulVideoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 首页相关接口
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/homeController")
@Api(tags = "首页相关")
public class HomeController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/expertChat", method = RequestMethod.POST)
	@ApiOperation(value = "达人专访", notes = "达人专访")
	public ApiExpertChatResult expertChat(@RequestBody ApiExpertChatInput input) {

		return apiFactory.getApiExpertChat().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/wonderfulVideo", method = RequestMethod.POST)
	@ApiOperation(value = "精彩视频", notes = "精彩视频")
	public ApiWonderfulVideoResult wonderfulVideo(@RequestBody ApiWonderfulVideoInput input) {

		return apiFactory.getApiWonderfulVideo().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/hotTopic", method = RequestMethod.POST)
	@ApiOperation(value = "热门话题", notes = "热门话题")
	public ApiHotTopicResult hotTopic(@RequestBody ApiHotTopicInput input) {

		return apiFactory.getApiHotTopic().api(input);
		
	}

}
