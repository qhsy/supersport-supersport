package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiBeginLiveInput;
import com.uhutu.sportcenter.z.result.ApiBeginLiveResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 直播相关接口
 * 
 * @author 逄小帅
 *
 */
@RestController
@RequestMapping(value = "/api/liveNewController")
@Api(tags = "新直播相关")
public class LiveNewController {

	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/beginLive", method = RequestMethod.POST)
	@ApiOperation(value = "开始直播", notes = "开始直播")
	public ApiBeginLiveResult beginLive(@RequestBody ApiBeginLiveInput input, HttpServletRequest request) {

		return apiFactory.getApiBeginLive().api(input);

	}

	

}
