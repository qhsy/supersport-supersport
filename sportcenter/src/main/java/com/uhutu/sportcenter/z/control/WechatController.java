package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiWechatConfigInfoInput;
import com.uhutu.sportcenter.z.input.ApiWechatUserLoginInput;
import com.uhutu.sportcenter.z.input.ApiWechatUserLoginInput2;
import com.uhutu.sportcenter.z.result.ApiWechatConfigInfoResult;
import com.uhutu.sportcenter.z.result.ApiWechatUserLoginResult;
import com.uhutu.sportcenter.z.result.ApiWechatUserLoginResult2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/wechatController")
@Api(tags = "微信配置信息相关")
public class WechatController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/configInfo", method = RequestMethod.POST)
	@ApiOperation(value = "微信配置信息", notes = "微信相关")
	public ApiWechatConfigInfoResult configInfo(@RequestBody ApiWechatConfigInfoInput input) {

		return apiFactory.getApiWechatConfigInfo().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/authLogin", method = RequestMethod.POST)
	@ApiOperation(value = "微信配置信息", notes = "微信相关")
	public ApiWechatUserLoginResult authLogin(@RequestBody ApiWechatUserLoginInput input) {

		return apiFactory.getApiWechatUserLogin().api(input);

	}
	
	@ResponseBody
	@RequestMapping(value = "/authLogin2", method = RequestMethod.POST)
	@ApiOperation(value = "微信配置信息", notes = "微信相关")
	public ApiWechatUserLoginResult2 authLogin2(@RequestBody ApiWechatUserLoginInput2 input) {

		return apiFactory.getApiWechatUserLogin2().api(input);

	}

}
