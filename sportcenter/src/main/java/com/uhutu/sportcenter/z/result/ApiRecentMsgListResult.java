package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ApiMsgNoticeInfo;
import com.uhutu.sportcenter.z.entity.MsgNumInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 最近消息列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRecentMsgListResult extends RootApiResult {
	
	@ApiModelProperty(value="系统消息")
	private ApiMsgNoticeInfo sytemMsgInfo = null;

	@ApiModelProperty(value="问答消息")
	private ApiMsgNoticeInfo answerMsgInfo = null;
	
	@ApiModelProperty(value = "消息数量列表", notes = "消息数量列表")
	List<MsgNumInfo> msgNumInfos = new ArrayList<MsgNumInfo>();

	public ApiMsgNoticeInfo getSytemMsgInfo() {
		return sytemMsgInfo;
	}

	public void setSytemMsgInfo(ApiMsgNoticeInfo sytemMsgInfo) {
		this.sytemMsgInfo = sytemMsgInfo;
	}

	public ApiMsgNoticeInfo getAnswerMsgInfo() {
		return answerMsgInfo;
	}

	public void setAnswerMsgInfo(ApiMsgNoticeInfo answerMsgInfo) {
		this.answerMsgInfo = answerMsgInfo;
	}

	public List<MsgNumInfo> getMsgNumInfos() {
		return msgNumInfos;
	}

	public void setMsgNumInfos(List<MsgNumInfo> msgNumInfos) {
		this.msgNumInfos = msgNumInfos;
	}

}
