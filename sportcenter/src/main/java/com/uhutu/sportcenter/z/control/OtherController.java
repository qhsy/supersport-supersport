package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.input.ApiIosRenovateInput;
import com.uhutu.sportcenter.z.input.ApiStartUpInput;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
import com.uhutu.sportcenter.z.result.ApiIosRenovateResult;
import com.uhutu.sportcenter.z.result.ApiStartUpResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 其他相关接口
 * 
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/otherController")
@Api(tags = "其他")
public class OtherController {

	@Autowired
	private ApiFactory apiFactory;

	// @ResponseBody
	// @RequestMapping(value = "/homePageSecond", method = RequestMethod.POST)
	// @ApiOperation(value = "新首页二", notes = "新首页二")
	// public ApiHomePageSecondResult homePageSecond(@RequestBody
	// ApiHomePageSecondInput input) {
	//
	// return apiFactory.getApiHomePageSecond().api(input);
	//
	// }

	// @ResponseBody
	// @RequestMapping(value = "/expertChat", method = RequestMethod.POST)
	// @ApiOperation(value = "达人专访", notes = "达人专访")
	// public ApiExpertChatResult expertChat(@RequestBody ApiExpertChatInput
	// input) {
	//
	// return apiFactory.getApiExpertChat().api(input);
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/wonderfulVideo", method = RequestMethod.POST)
	// @ApiOperation(value = "精彩视频", notes = "精彩视频")
	// public ApiWonderfulVideoResult wonderfulVideo(@RequestBody
	// ApiWonderfulVideoInput input) {
	//
	// return apiFactory.getApiWonderfulVideo().api(input);
	// }
	//
	// @ResponseBody
	// @RequestMapping(value = "/hotTopic", method = RequestMethod.POST)
	// @ApiOperation(value = "热门话题", notes = "热门话题")
	// public ApiHotTopicResult hotTopic(@RequestBody ApiHotTopicInput input) {
	//
	// return apiFactory.getApiHotTopic().api(input);
	//
	// }

	@ResponseBody
	@RequestMapping(value = "/startUpApi", method = RequestMethod.POST)
	@ApiOperation(value = "启动页图片接口", notes = "启动页图片接口")
	public ApiStartUpResult startUpApi(@RequestBody ApiStartUpInput input) {

		return apiFactory.getApiStartUp().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/iosRenovatePage", method = RequestMethod.POST)
	@ApiOperation(value = "IOS热修复接口", notes = "IOS热修复接口")
	public ApiIosRenovateResult iosRenovatePage(@RequestBody ApiIosRenovateInput input) {

		return apiFactory.getApiIosRenovate().api(input);

	}

	// @ResponseBody
	// @RequestMapping(value = "/contentType", method = RequestMethod.POST)
	// @ApiOperation(value = "值得看", notes = "值得看")
	// public ApiContentTypeResult contentType(@RequestBody ApiContentTypeInput
	// input) {
	//
	// return apiFactory.getApiContentType().api(input);
	//
	// }

	// @ResponseBody
	// @RequestMapping(value = "/contentWorth", method = RequestMethod.POST)
	// @ApiOperation(value = "分类详情页", notes = "分类详情页")
	// public ApiContentWorthResult contentWorth(@RequestBody
	// ApiContentWorthInput input) {
	//
	// return apiFactory.getApiContentWorth().api(input);
	//
	// }

}
