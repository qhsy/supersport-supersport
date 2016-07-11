package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提问
 *
 */
@ApiModel
public class ApiForAskQuestionResult extends RootApiResult {

	@ApiModelProperty(value = "问达编号", notes = "问达编号", required = true, example = "MeiZi666")
	private String code = "";

	@ApiModelProperty(value = "微信支付参数")
	private WechatH5PayResponse wechatH5PayResponse = new WechatH5PayResponse();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public WechatH5PayResponse getWechatH5PayResponse() {
		return wechatH5PayResponse;
	}

	public void setWechatH5PayResponse(WechatH5PayResponse wechatH5PayResponse) {
		this.wechatH5PayResponse = wechatH5PayResponse;
	}

}
