package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiComplainInfoInput;
import com.uhutu.sportcenter.z.input.ApiContentDetailInput;
import com.uhutu.sportcenter.z.input.ApiContentPhotosInput;
import com.uhutu.sportcenter.z.input.ApiContentReadCountInput;
import com.uhutu.sportcenter.z.input.ApiContentRecommInput;
import com.uhutu.sportcenter.z.input.ApiForLabelsInput;
import com.uhutu.sportcenter.z.input.ApiForSportsInput;
import com.uhutu.sportcenter.z.input.ApiHomePageInput;
import com.uhutu.sportcenter.z.input.ApiOperContentInput;
import com.uhutu.sportcenter.z.input.ApiPublishContentPhotosInput;
import com.uhutu.sportcenter.z.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.z.input.ApiShareInfoInput;
import com.uhutu.sportcenter.z.input.ApiSportChickenSoupInput;
import com.uhutu.sportcenter.z.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.z.input.ApiSupportPraiseInput;
import com.uhutu.sportcenter.z.input.ApiThemePageInput;
import com.uhutu.sportcenter.z.result.ApiComplainInfoResult;
import com.uhutu.sportcenter.z.result.ApiContentDetailResult;
import com.uhutu.sportcenter.z.result.ApiContentPhotosResult;
import com.uhutu.sportcenter.z.result.ApiContentReadCountResult;
import com.uhutu.sportcenter.z.result.ApiContentRecommResult;
import com.uhutu.sportcenter.z.result.ApiForLabelsResult;
import com.uhutu.sportcenter.z.result.ApiForSportsResult;
import com.uhutu.sportcenter.z.result.ApiHomePageResult;
import com.uhutu.sportcenter.z.result.ApiOperContentResult;
import com.uhutu.sportcenter.z.result.ApiPublishContentPhotosResult;
import com.uhutu.sportcenter.z.result.ApiPublishSportingMomentResult;
import com.uhutu.sportcenter.z.result.ApiShareInfoResult;
import com.uhutu.sportcenter.z.result.ApiSportChickenSoupResult;
import com.uhutu.sportcenter.z.result.ApiSportingMomentsResult;
import com.uhutu.sportcenter.z.result.ApiSupportPraiseResult;
import com.uhutu.sportcenter.z.result.ApiThemePageResult;

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
	@RequestMapping(value = "/sportCategory", method = RequestMethod.POST)
	@ApiOperation(value = "各种运动类型接口", notes = "运动类型")
	public ApiForSportsResult sportCategory(@RequestBody ApiForSportsInput input) {

		return apiFactory.getApiForSports().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/publicContentPhotos", method = RequestMethod.POST)
	@ApiOperation(value = "发布图集", notes = "运动类型")
	public ApiPublishContentPhotosResult publicContentPhotos(@RequestBody ApiPublishContentPhotosInput input) {

		return apiFactory.getApiPublishContentPhotos().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/contentComplain", method = RequestMethod.POST)
	@ApiOperation(value = "内容投诉", notes = "内容详情页投诉接口")
	public ApiComplainInfoResult contentComplain(@RequestBody ApiComplainInfoInput input) {

		return apiFactory.getApiComplainInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/contentRecomm", method = RequestMethod.POST)
	@ApiOperation(value = "编辑推荐信息", notes = "内容详情中编辑推荐信息")
	public ApiContentRecommResult contentRecomm(@RequestBody ApiContentRecommInput input) {

		return apiFactory.getApiContentRecommInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/delContent", method = RequestMethod.POST)
	@ApiOperation(value = "内容逻辑删除", notes = "内容信息")
	public ApiOperContentResult delContent(@RequestBody ApiOperContentInput input) {

		return apiFactory.getApiOperContent().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/themePage", method = RequestMethod.POST)
	@ApiOperation(value = "专题信息", notes = "专题信息")
	public ApiThemePageResult themePage(@RequestBody ApiThemePageInput input) {

		return apiFactory.getApiThemePage().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/shareInfo", method = RequestMethod.POST)
	@ApiOperation(value = "分享信息", notes = "分享信息")
	public ApiShareInfoResult shareInfo(@RequestBody ApiShareInfoInput input) {

		return apiFactory.getApiShareInfo().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/contentReadCount", method = RequestMethod.POST)
	@ApiOperation(value = "增加阅读量", notes = "增加阅读量")
	public ApiContentReadCountResult shareInfo(@RequestBody ApiContentReadCountInput input) {

		return apiFactory.getApiContentReadCount().api(input);

	}

	@ResponseBody
	@RequestMapping(value = "/sportChickenSoup", method = RequestMethod.POST)
	@ApiOperation(value = "运动小知识", notes = "运动小知识")
	public ApiSportChickenSoupResult shareInfo(@RequestBody ApiSportChickenSoupInput input) {

		return apiFactory.getApiSportChickenSoup().api(input);

	}
}
