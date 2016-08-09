package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息关注状态
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgFocusInput extends RootApiInput {
	
	@ApiModelProperty(value="消息类型",example="系统消息：system,问答助手：answer")
	private String msgType;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
