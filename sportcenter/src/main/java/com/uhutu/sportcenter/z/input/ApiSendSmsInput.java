package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 短信发送
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiSendSmsInput extends RootApiInput {
	
	@ApiModelProperty(value = "手机号码", notes = "手机号码", required = true)
	private String mobileNO = "";
	
	@ApiModelProperty(value = "消息类型", example = "register(注册),login(登录),resetpwd(重置密码),forgetpwd(忘记密码)", required = true)
	private String msgType = "";

	public String getMobileNO() {
		return mobileNO;
	}

	public void setMobileNO(String mobileNO) {
		this.mobileNO = mobileNO;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
