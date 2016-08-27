package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.GoldCoinPayResponse;
import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForAnswerOrderResult extends RootApiResult {

	@ApiModelProperty(value = "微信支付参数")
	private WechatH5PayResponse wechatH5PayResponse = new WechatH5PayResponse();
	
	@ApiModelProperty(value="微信移动支付参数")
	private WechatPayResponse wechatMobilePayResponse = new WechatPayResponse();
	
	@ApiModelProperty(value="金币支付")
	private GoldCoinPayResponse goldCoinPayResponse = new GoldCoinPayResponse();

	public WechatH5PayResponse getWechatH5PayResponse() {
		return wechatH5PayResponse;
	}

	public void setWechatH5PayResponse(WechatH5PayResponse wechatH5PayResponse) {
		this.wechatH5PayResponse = wechatH5PayResponse;
	}

	public WechatPayResponse getWechatMobilePayResponse() {
		return wechatMobilePayResponse;
	}

	public void setWechatMobilePayResponse(WechatPayResponse wechatMobilePayResponse) {
		this.wechatMobilePayResponse = wechatMobilePayResponse;
	}

	public GoldCoinPayResponse getGoldCoinPayResponse() {
		return goldCoinPayResponse;
	}

	public void setGoldCoinPayResponse(GoldCoinPayResponse goldCoinPayResponse) {
		this.goldCoinPayResponse = goldCoinPayResponse;
	}

}
