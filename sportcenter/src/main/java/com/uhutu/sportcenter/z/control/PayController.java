package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/payController")
@Api(tags = "支付接口相关")
public class PayController {
	
	@Autowired
	private ApiFactory apiFactory;
	
	@ResponseBody
	@RequestMapping(value = "/wechatH5Pay", method = RequestMethod.POST)
	@ApiOperation(value = "微信h5支付", notes = "微信h5支付")
	public ApiWechatH5PayResult wechatConfigInfo(@RequestBody ApiWechatH5PayInput input,HttpServletRequest request) {

		String[] paths = request.getRequestURL().toString().split("/");
		
		String path = paths[0]+"//"+paths[2];
		
		input.setServeIP(path);
		
		input.setRomoteIP(request.getRemoteAddr());
		
		return apiFactory.getApiWechatH5Pay().api(input);
	}

}
