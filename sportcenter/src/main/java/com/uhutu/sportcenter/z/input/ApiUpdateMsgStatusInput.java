package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息状态更新
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUpdateMsgStatusInput extends RootApiInput {
	
	@ApiModelProperty(value="用户编号")
	private String userCode;
	
	@ApiModelProperty(value="消息类型")
	private String msgType;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
