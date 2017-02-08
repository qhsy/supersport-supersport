package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容红包
 * @author 逄小帅
 *
 */
public class ApiContentRedPackResult extends RootApiResult {
	
	@ApiModelProperty(value="微信移动支付参数")
	private WechatPayResponse wechatMobilePayResponse = new WechatPayResponse();

	public WechatPayResponse getWechatMobilePayResponse() {
		return wechatMobilePayResponse;
	}

	public void setWechatMobilePayResponse(WechatPayResponse wechatMobilePayResponse) {
		this.wechatMobilePayResponse = wechatMobilePayResponse;
	}
	
}
