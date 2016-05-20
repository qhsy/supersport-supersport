package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MsgNoticeInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息通知列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgNoticeListResult extends RootApiResult {
	
	@ApiModelProperty(name="消息通知列表")
	private List<MsgNoticeInfo> msgNoticeInfos = new ArrayList<MsgNoticeInfo>();
	
	@ApiModelProperty(value="是否还有下一页")
	private boolean nextflag = false;

	public List<MsgNoticeInfo> getMsgNoticeInfos() {
		return msgNoticeInfos;
	}

	public void setMsgNoticeInfos(List<MsgNoticeInfo> msgNoticeInfos) {
		this.msgNoticeInfos = msgNoticeInfos;
	}

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

}
