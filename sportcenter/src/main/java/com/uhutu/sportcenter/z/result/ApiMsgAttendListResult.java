package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MsgAttendInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息关注通知
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgAttendListResult extends RootApiResult {
	
	@ApiModelProperty(name="消息关注列表")
	private List<MsgAttendInfo> msgAttendInfos = new ArrayList<MsgAttendInfo>();

	public List<MsgAttendInfo> getMsgAttendInfos() {
		return msgAttendInfos;
	}

	public void setMsgAttendInfos(List<MsgAttendInfo> msgAttendInfos) {
		this.msgAttendInfos = msgAttendInfos;
	}

}
