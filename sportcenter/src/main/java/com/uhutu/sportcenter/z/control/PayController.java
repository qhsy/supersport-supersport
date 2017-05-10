package com.uhutu.sportcenter.z.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiCoinAccInfoInput;
import com.uhutu.sportcenter.z.input.ApiCoinChargeInput;
import com.uhutu.sportcenter.z.input.ApiCoinFlowInfoInput;
import com.uhutu.sportcenter.z.input.ApiCoinPayInput;
import com.uhutu.sportcenter.z.input.ApiWechatH5PayInput;
import com.uhutu.sportcenter.z.input.ApiWechatMobilePayInput;
import com.uhutu.sportcenter.z.result.ApiCoinAccInfoResult;
import com.uhutu.sportcenter.z.result.ApiCoinChargeResult;
import com.uhutu.sportcenter.z.result.ApiCoinFlowInfoResult;
import com.uhutu.sportcenter.z.result.ApiCoinPayResult;
import com.uhutu.sportcenter.z.result.ApiWechatH5PayResult;
import com.uhutu.sportcenter.z.result.ApiWechatMobilePayResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@RestController
//@RequestMapping(value = "/api/payController")
//@Api(tags = "支付接口相关")
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
	
	@ResponseBody
	@RequestMapping(value = "/wechatMobilePay", method = RequestMethod.POST)
	@ApiOperation(value = "微信移动支付", notes = "微信移动支付")
	public ApiWechatMobilePayResult wechatMobilePay(@RequestBody ApiWechatMobilePayInput input,HttpServletRequest request) {

		String[] paths = request.getRequestURL().toString().split("/");
		
		String path = paths[0]+"//"+paths[2];
		
		input.setServeIP(path);
		
		input.setRomoteIP(request.getRemoteAddr());
		
		return apiFactory.getApiWechatMobilePay().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/coinCharge", method = RequestMethod.POST)
	@ApiOperation(value = "金币充值", notes = "金币充值")
	public ApiCoinChargeResult coinCharge(@RequestBody ApiCoinChargeInput input) {

		return apiFactory.getApiCoinCharge().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/coinAccInfo", method = RequestMethod.POST)
	@ApiOperation(value = "金币账户信息", notes = "金币账户信息")
	public ApiCoinAccInfoResult coinAccInfo(@RequestBody ApiCoinAccInfoInput input) {

		return apiFactory.getApiCoinAccInfo().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/coinPay", method = RequestMethod.POST)
	@ApiOperation(value = "金币支付", notes = "金币支付")
	public ApiCoinPayResult coinAccInfo(@RequestBody ApiCoinPayInput input) {

		return apiFactory.getApiCoinPay().api(input);
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/coinFlowInfo", method = RequestMethod.POST)
	@ApiOperation(value = "金币流水信息", notes = "金币流水信息")
	public ApiCoinFlowInfoResult coinFlowInfo(@RequestBody ApiCoinFlowInfoInput input) {

		return apiFactory.getApiCoinFlowInfo().api(input);
		
	}

}
