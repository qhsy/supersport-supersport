package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;

/**
 * 微信后台接口统一响应参数
 * @author 逄小帅
 *
 */
public class WechatUnifyResponse implements IPayResponse{
	
	/*返回状态码*/
	private String return_code;
	
	/*返回信息*/
	private String return_msg;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

}
