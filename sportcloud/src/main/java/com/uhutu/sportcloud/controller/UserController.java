package com.uhutu.sportcloud.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.api.APiStartPage;
import com.uhutu.sportcenter.api.ApiForLogin;
import com.uhutu.sportcenter.api.ApiLoginOut;
import com.uhutu.sportcenter.api.ApiSendSms;
import com.uhutu.sportcenter.api.ApiSocialLogin;
import com.uhutu.sportcenter.api.ApiUserInfo;
import com.uhutu.sportcenter.api.ApiUserRegister;
import com.uhutu.sportcenter.api.ApiVersionInfo;
import com.uhutu.sportcenter.api.input.APiStartPageInput;
import com.uhutu.sportcenter.api.input.ApiForLoginInput;
import com.uhutu.sportcenter.api.input.ApiLoginOutInput;
import com.uhutu.sportcenter.api.input.ApiSendSmsInput;
import com.uhutu.sportcenter.api.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.api.input.ApiUserInfoInput;
import com.uhutu.sportcenter.api.input.ApiUserRegInput;
import com.uhutu.sportcenter.api.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.api.result.APiStartPageResult;
import com.uhutu.sportcenter.api.result.ApiForLoginResult;
import com.uhutu.sportcenter.api.result.ApiLoginOutResult;
import com.uhutu.sportcenter.api.result.ApiSendSmsResult;
import com.uhutu.sportcenter.api.result.ApiSocialLoginResult;
import com.uhutu.sportcenter.api.result.ApiUserInfoResult;
import com.uhutu.sportcenter.api.result.ApiUserRegResult;
import com.uhutu.sportcenter.api.result.ApiVersionInfoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关控制器
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/userController")
@Api(tags="",description="用户相关操作")
public class UserController {
	
	@ResponseBody
	@RequestMapping(value = "/versionInfo", method = RequestMethod.POST)
	@ApiOperation(value = "app版本升级提示接口", notes = "版本升级")
	public ApiVersionInfoResult versionInfo(@RequestBody ApiVersionInfoInput input) {
		
		return new ApiVersionInfo().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ApiOperation(value = "用户注册接口", notes = "用户注册")
	public ApiUserRegResult userRegister(@RequestBody ApiUserRegInput input) {
		
		return new ApiUserRegister().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/startPage", method = RequestMethod.POST)
	@ApiOperation(value = "启动页接口", notes = "app启动页")
	public APiStartPageResult startPage(@RequestBody APiStartPageInput input) {
		
		return new APiStartPage().process(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/socialLogin", method = RequestMethod.POST)
	@ApiOperation(value = "社交类app登录", notes = "用户登录")
	public ApiSocialLoginResult socialLogin(@RequestBody ApiSocialLoginInput input) {
		
		return new ApiSocialLogin().process(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	@ApiOperation(value = "短信发送接口", notes = "用户登录")
	public ApiSendSmsResult sendSms(@RequestBody ApiSendSmsInput input) {
		
		return new ApiSendSms().process(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	@ApiOperation(value = "用户退出接口", notes = "用户相关")
	public ApiLoginOutResult loginOut(@RequestBody ApiLoginOutInput input) {
		
		return new ApiLoginOut().process(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "用户登录接口", notes = "用户相关")
	public ApiForLoginResult login(@RequestBody ApiForLoginInput input) {
		
		return new ApiForLogin().process(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/userInfo",method = RequestMethod.POST)
	@ApiOperation(value="用户信息接口",notes="用户相关")
	public ApiUserInfoResult userInfo(@RequestBody ApiUserInfoInput infoInput){
		
		return new ApiUserInfo().process(infoInput);
	}
}
