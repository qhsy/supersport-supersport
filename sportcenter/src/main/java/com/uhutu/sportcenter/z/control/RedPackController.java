package com.uhutu.sportcenter.z.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.uhutu.sportcenter.z.api.ApiFactory;
import com.uhutu.sportcenter.z.input.ApiRedPackInfoListInput;
import com.uhutu.sportcenter.z.input.ApiWalletInfoInput;
import com.uhutu.sportcenter.z.result.ApiRedPackInfoListResult;
import com.uhutu.sportcenter.z.result.ApiWalletInfoResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 红包打赏
 * 
 * @author pangjh
 *
 */
@RestController
@RequestMapping(value = "/api/redPackController")
@Api(tags = "红包打赏相关接口")
public class RedPackController {

	@Autowired
	private ApiFactory apiFactory;

	@ResponseBody
	@RequestMapping(value = "/redPackInfos", method = RequestMethod.POST)
	@ApiOperation(value = "红包信息列表", notes = "红包信息列表")
	public ApiRedPackInfoListResult redPackInfos(@RequestBody ApiRedPackInfoListInput input) {

		return apiFactory.getApiRedPackInfoList().api(input);
	}
	
	@ResponseBody
	@RequestMapping(value = "/walletInfo", method = RequestMethod.POST)
	@ApiOperation(value = "钱包信息", notes = "钱包信息")
	public ApiWalletInfoResult walletInfo(@RequestBody ApiWalletInfoInput input) {

		return apiFactory.getApiWalletInfo().api(input);
	}

	
}
