package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiUserPowerInitInput;
import com.uhutu.sportcenter.z.result.ApiUserPowerInitResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户能量捐赠相关
 * 
 * @author pang_jhui
 *
 */
@RestController
@RequestMapping(value = "/api/userPowerController")
@Api(tags = "用户能量捐赠")
public class UserPowerController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/initUserPower", method = RequestMethod.POST)
	@ApiOperation(value = "初始化用户能量", notes = "用户能量相关")
	public ApiUserPowerInitResult initUserPower(@RequestBody ApiUserPowerInitInput input) {

		return apiFactory.getApiUserPowerInit().api(input);

	}

}
