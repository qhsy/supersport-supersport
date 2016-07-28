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
	
	@ApiModelProperty(value="消息类型",example="01:关注 02:评论 03:通知 04:点赞 05:问答消息")
	private String msgType;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

}
