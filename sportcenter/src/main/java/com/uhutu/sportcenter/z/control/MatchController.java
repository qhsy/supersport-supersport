package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiMatchInfoInput;
import com.uhutu.sportcenter.z.input.ApiMatchInfoListInput;
import com.uhutu.sportcenter.z.input.ApiMatchSignListInput;
import com.uhutu.sportcenter.z.input.ApiMySignListInput;
import com.uhutu.sportcenter.z.input.ApiShareMatchInfoInput;
import com.uhutu.sportcenter.z.result.ApiMacthInfoListResult;
import com.uhutu.sportcenter.z.result.ApiMatchInfoResult;
import com.uhutu.sportcenter.z.result.ApiMatchSignListResult;
import com.uhutu.sportcenter.z.result.ApiMySignListResult;
import com.uhutu.sportcenter.z.result.ApiShareMatchInfoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 赛事相关
 * 
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/matchController")
@Api(tags = "赛事相关接口")
public class MatchController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/matchInfoList", method = RequestMethod.POST)
	@ApiOperation(value = "赛事信息列表", notes = "赛事信息列表")
	public ApiMacthInfoListResult matchInfoList(@RequestBody ApiMatchInfoListInput input) {
		
		return apiFactory.getApiMatchInfoList().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/matchInfo", method = RequestMethod.POST)
	@ApiOperation(value = "赛事信息", notes = "赛事信息")
	public ApiMatchInfoResult matchInfo(@RequestBody ApiMatchInfoInput input) {
		
		return apiFactory.getApiMatchInfo().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/matchSignInfo", method = RequestMethod.POST)
	@ApiOperation(value = "赛事报名信息", notes = "赛事报名信息")
	public ApiMatchSignListResult matchSignInfo(@RequestBody ApiMatchSignListInput input) {
		
		return apiFactory.getApiMatchSignList().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/shareMatchInfo", method = RequestMethod.POST)
	@ApiOperation(value = "赛事分享信息", notes = "赛事分享信息")
	public ApiShareMatchInfoResult shareMatchInfo(@RequestBody ApiShareMatchInfoInput input) {
		
		return apiFactory.getApiShareMatchInfo().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/mySignList", method = RequestMethod.POST)
	@ApiOperation(value = "我的报名信息", notes = "我的报名信息")
	public ApiMySignListResult mySignList(@RequestBody ApiMySignListInput input) {
		
		return apiFactory.getApiMySignList().api(input);
		
	}

}
