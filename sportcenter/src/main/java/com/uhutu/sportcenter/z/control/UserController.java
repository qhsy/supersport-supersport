package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.ApiFactory;
import com.uhutu.sportcenter.z.input.APiStartPageInput;
import com.uhutu.sportcenter.z.input.ApiForLoginInput;
import com.uhutu.sportcenter.z.input.ApiLoginOutInput;
import com.uhutu.sportcenter.z.input.ApiSendSmsInput;
import com.uhutu.sportcenter.z.input.ApiSetUserFavoerInput;
import com.uhutu.sportcenter.z.input.ApiSocialLoginInput;
import com.uhutu.sportcenter.z.input.ApiUserInfoInput;
import com.uhutu.sportcenter.z.input.ApiUserRegInput;
import com.uhutu.sportcenter.z.input.ApiUserResetPwdInput;
import com.uhutu.sportcenter.z.input.ApiVersionInfoInput;
import com.uhutu.sportcenter.z.result.APiStartPageResult;
import com.uhutu.sportcenter.z.result.ApiForLoginResult;
import com.uhutu.sportcenter.z.result.ApiLoginOutResult;
import com.uhutu.sportcenter.z.result.ApiSendSmsResult;
import com.uhutu.sportcenter.z.result.ApiSetUserFavorResult;
import com.uhutu.sportcenter.z.result.ApiSocialLoginResult;
import com.uhutu.sportcenter.z.result.ApiUserInfoResult;
import com.uhutu.sportcenter.z.result.ApiUserRegResult;
import com.uhutu.sportcenter.z.result.ApiUserResetPwdResult;
import com.uhutu.sportcenter.z.result.ApiVersionInfoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户相关控制器
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/userController")
@Api(tags="用户相关接口")
public class UserController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/versionInfo", method = RequestMethod.POST)
	@ApiOperation(value = "app版本升级提示接口", notes = "版本升级")
	public ApiVersionInfoResult versionInfo(@RequestBody ApiVersionInfoInput input) {
		
		return apiFactory.getApiVersionInfo().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	@ApiOperation(value = "用户注册接口", notes = "用户注册")
	public ApiUserRegResult userRegister(@RequestBody ApiUserRegInput input) {
		
		return apiFactory.getApiUserRegister().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/startPage", method = RequestMethod.POST)
	@ApiOperation(value = "启动页接口", notes = "app启动页")
	public APiStartPageResult startPage(@RequestBody APiStartPageInput input) {
		
		return apiFactory.getApiStartPage().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/socialLogin", method = RequestMethod.POST)
	@ApiOperation(value = "社交类app登录", notes = "用户登录")
	public ApiSocialLoginResult socialLogin(@RequestBody ApiSocialLoginInput input) {
		
		return apiFactory.getApiSocialLogin().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/sendSms", method = RequestMethod.POST)
	@ApiOperation(value = "短信发送接口", notes = "用户登录")
	public ApiSendSmsResult sendSms(@RequestBody ApiSendSmsInput input) {
		
		return apiFactory.getApiSendSms().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/loginOut", method = RequestMethod.POST)
	@ApiOperation(value = "用户退出接口", notes = "用户相关")
	public ApiLoginOutResult loginOut(@RequestBody ApiLoginOutInput input) {
		
		return apiFactory.getApiLoginOut().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ApiOperation(value = "用户登录接口", notes = "用户相关")
	public ApiForLoginResult login(@RequestBody ApiForLoginInput input) {
		
		return apiFactory.getApiForLogin().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value="/userInfo",method = RequestMethod.POST)
	@ApiOperation(value="用户信息接口",notes="用户相关")
	public ApiUserInfoResult userInfo(@RequestBody ApiUserInfoInput infoInput){
		
		return apiFactory.getApiUserInfo().api(infoInput);
	}
	
	@ResponseBody
	@RequestMapping(value="/resetPwd",method = RequestMethod.POST)
	@ApiOperation(value="用户重置密码",notes="用户相关")
	public ApiUserResetPwdResult resetPwd(@RequestBody ApiUserResetPwdInput input){
		
		return apiFactory.getApiUserResetPwd().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value="/setUserFavor",method = RequestMethod.POST)
	@ApiOperation(value="设置用户喜欢",notes="用户相关")
	public ApiSetUserFavorResult setUserFavor(@RequestBody ApiSetUserFavoerInput input){
		
		return apiFactory.getApiSetUserFavor().api(input);
	}
	
}
