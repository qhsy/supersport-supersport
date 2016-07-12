package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForAnswerOrderResult extends RootApiResult {

	@ApiModelProperty(value = "微信支付参数")
	private WechatH5PayResponse wechatH5PayResponse = new WechatH5PayResponse();

	public WechatH5PayResponse getWechatH5PayResponse() {
		return wechatH5PayResponse;
	}

	public void setWechatH5PayResponse(WechatH5PayResponse wechatH5PayResponse) {
		this.wechatH5PayResponse = wechatH5PayResponse;
	}

}
