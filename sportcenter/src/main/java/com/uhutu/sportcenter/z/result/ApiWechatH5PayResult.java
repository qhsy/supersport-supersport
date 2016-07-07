package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.pay.z.response.WechatH5PayResponse;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信h5支付result
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatH5PayResult extends RootApiResult {
	
	@ApiModelProperty(value="支付信息")
	private WechatH5PayResponse wechatH5PayInfo;

	public WechatH5PayResponse getWechatH5PayInfo() {
		return wechatH5PayInfo;
	}

	public void setWechatH5PayInfo(WechatH5PayResponse wechatH5PayInfo) {
		this.wechatH5PayInfo = wechatH5PayInfo;
	}
	

}
