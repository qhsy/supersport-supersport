package com.uhutu.sportcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.api.ApiFactory;
import com.uhutu.sportcenter.api.input.ApiContentDetailInput;
import com.uhutu.sportcenter.api.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.api.input.ApiForLabelsInput;
import com.uhutu.sportcenter.api.input.ApiForSportsInput;
import com.uhutu.sportcenter.api.input.ApiHomePageInput;
import com.uhutu.sportcenter.api.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.api.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.api.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.api.result.ApiContentDetailResult;
import com.uhutu.sportcenter.api.result.ApiContentPhotosResult;
import com.uhutu.sportcenter.api.result.ApiForLabelsResult;
import com.uhutu.sportcenter.api.result.ApiForSportsResult;
import com.uhutu.sportcenter.api.result.ApiHomePageResult;
import com.uhutu.sportcenter.api.result.ApiPublishSportingMomentResult;
import com.uhutu.sportcenter.api.result.ApiSportingMomentsResult;
import com.uhutu.sportcenter.api.result.ApiSupportPraiseResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 体育内容相关
 * 
 * @author xiegj
 *
 */
@RestController
@RequestMapping(value = "/api/contentController")
@Api(tags = "内容相关接口")
public class ContentController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/homePage", method = RequestMethod.POST)
	@ApiOperation(value = "app首页接口", notes = "首页内容展示")
	public ApiHomePageResult versionInfo(@RequestBody ApiHomePageInput input) {

		return apiFactory.getApiHomePage().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/sportingMoments", method = RequestMethod.POST)
	@ApiOperation(value = "运动时刻接口", notes = "运动时刻展示")
	public ApiSportingMomentsResult versionInfo(@RequestBody ApiSportingMomentsInput input) {

		return apiFactory.getApiSportingMoments().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/supportPraise", method = RequestMethod.POST)
	@ApiOperation(value = "点赞接口", notes = "可对内容进行么么哒与嘘嘘")
	public ApiSupportPraiseResult versionInfo(@RequestBody ApiSupportPraiseInput input) {

		return apiFactory.getApiSupportPraise().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/forLabels", method = RequestMethod.POST)
	@ApiOperation(value = "运动标签获取接口", notes = "运动标签")
	public ApiForLabelsResult versionInfo(@RequestBody ApiForLabelsInput input) {

		return apiFactory.getApiForLabels().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/publishSportingMoment", method = RequestMethod.POST)
	@ApiOperation(value = "发布运动时刻接口", notes = "发布运动时刻内容")
	public ApiPublishSportingMomentResult versionInfo(@RequestBody ApiPublishSportingMomentInput input) {

		return apiFactory.getApiPublishSportingMoment().api(input);
	}

	@ResponseBody
	@RequestMapping(value = "/contentDetail", method = RequestMethod.POST)
	@ApiOperation(value = "内容详情", notes = "内容详情")
	public ApiContentDetailResult contentDetail(@RequestBody ApiContentDetailInput input) {

		return apiFactory.getContentDetailInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/contentPhotosDetail", method = RequestMethod.POST)
	@ApiOperation(value = "图集详情", notes = "图集详情")
	public ApiContentPhotosResult contentPhotosDetail(@RequestBody ApiContentPhotosInput input) {

		return apiFactory.getContentPhotosDetailInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/contentSports", method = RequestMethod.POST)
	@ApiOperation(value = "各种运动类型接口", notes = "运动类型")
	public ApiForSportsResult contentSports(@RequestBody ApiForSportsInput input) {

		return apiFactory.getApiForSports().api(input);

	}
}
