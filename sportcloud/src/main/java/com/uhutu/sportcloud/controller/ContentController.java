package com.uhutu.sportcloud.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.api.ApiHomePage;
import com.uhutu.sportcenter.api.ApiSportingMoments;
import com.uhutu.sportcenter.api.input.ApiHomePageInput;
import com.uhutu.sportcenter.api.input.ApiSportingMomentsInput;
import com.uhutu.sportcenter.api.result.ApiHomePageResult;
import com.uhutu.sportcenter.api.result.ApiSportingMomentsResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 体育内容相关
 * @author xiegj
 *
 */
@RestController
@RequestMapping(value = "/api/contentController")
@Api(tags="首页相关操作")
public class ContentController {
	
	@ResponseBody
	@RequestMapping(value = "/homePage", method = RequestMethod.POST)
	@ApiOperation(value = "app首页接口", notes = "首页内容展示")
	public ApiHomePageResult versionInfo(@RequestBody ApiHomePageInput input) {
		
		return new ApiHomePage().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/sportingMoments", method = RequestMethod.POST)
	@ApiOperation(value = "运动时刻接口", notes = "运动时刻")
	public ApiSportingMomentsResult versionInfo(@RequestBody ApiSportingMomentsInput input) {
		
		return new ApiSportingMoments().api(input);
	}

}
