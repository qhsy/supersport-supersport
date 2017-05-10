package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiKeyWordRecommInput;
import com.uhutu.sportcenter.z.input.ApiSearchMatchInput;
import com.uhutu.sportcenter.z.input.ApiSearchUserInput;
import com.uhutu.sportcenter.z.input.ApiSearchVideoInput;
import com.uhutu.sportcenter.z.result.ApiKeyWordRecommResult;
import com.uhutu.sportcenter.z.result.ApiSearchMatchResult;
import com.uhutu.sportcenter.z.result.ApiSearchUserResult;
import com.uhutu.sportcenter.z.result.ApiSearchVideoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 搜索相关
 * 
 * @author 逄小帅
 *
 */
//@RestController
//@RequestMapping(value = "/api/searchController")
//@Api(tags = "搜索相关接口")
public class SearchController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/searchUser", method = RequestMethod.POST)
	@ApiOperation(value = "搜索用户信息", notes = "搜索用户信息")
	public ApiSearchUserResult searchUser(@RequestBody ApiSearchUserInput input) {
		
		return apiFactory.getApiSearchUser().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchMatch", method = RequestMethod.POST)
	@ApiOperation(value = "搜索赛事信息", notes = "搜索赛事信息")
	public ApiSearchMatchResult searchMatch(@RequestBody ApiSearchMatchInput input) {
		
		return apiFactory.getApiSearchMatch().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchVideo", method = RequestMethod.POST)
	@ApiOperation(value = "搜索视频信息", notes = "搜索视频信息")
	public ApiSearchVideoResult searchVideo(@RequestBody ApiSearchVideoInput input) {
		
		return apiFactory.getApiSearchVideo().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/searchKeyWordRecomm", method = RequestMethod.POST)
	@ApiOperation(value = "搜索关键字推荐", notes = "搜索关键字推荐")
	public ApiKeyWordRecommResult searchKeyWordRecomm(@RequestBody ApiKeyWordRecommInput input) {
		
		return apiFactory.getApiKeyWordRecomm().api(input);
		
	}

}
