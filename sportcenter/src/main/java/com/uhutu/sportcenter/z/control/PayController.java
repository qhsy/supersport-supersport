package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiWechatConfigInfoInput;
import com.uhutu.sportcenter.z.result.ApiWechatConfigInfoResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/payController")
@Api(tags = "支付接口相关")
public class PayController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/wechatConfigInfo", method = RequestMethod.POST)
	@ApiOperation(value = "微信配置信息", notes = "微信")
	public ApiWechatConfigInfoResult wechatConfigInfo(@RequestBody ApiWechatConfigInfoInput input) {

		return apiFactory.getApiWechatConfigInfo().api(input);
	}

}
