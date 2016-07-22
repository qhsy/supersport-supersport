package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.WechatPayResponse;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信移动支付result
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatMobilePayResult extends RootApiResult {
	
	@ApiModelProperty(value="支付信息")
	private WechatPayResponse mobilePayInfo;

	public WechatPayResponse getMobilePayInfo() {
		return mobilePayInfo;
	}

	public void setMobilePayInfo(WechatPayResponse mobilePayInfo) {
		this.mobilePayInfo = mobilePayInfo;
	}

	
	

}
