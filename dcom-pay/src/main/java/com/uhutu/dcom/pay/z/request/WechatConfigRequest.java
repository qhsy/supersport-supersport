package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 微信配置信息请求
 * @author 逄小帅
 *
 */
public class WechatConfigRequest implements IPayRequest {
	
	/*当前请求页面路径*/
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
