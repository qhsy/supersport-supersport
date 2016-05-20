package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MsgPraiseInfo;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 点赞消息通知
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgPraiseListResult extends RootApiResult {
	
	@ApiModelProperty(name="点赞消息列表")
	private List<MsgPraiseInfo> msgPraiseInfos = new ArrayList<MsgPraiseInfo>();
	
	@ApiModelProperty(value="是否还有下一页")
	private boolean nextflag = false;
	

	public List<MsgPraiseInfo> getMsgPraiseInfos() {
		return msgPraiseInfos;
	}

	public void setMsgPraiseInfos(List<MsgPraiseInfo> msgPraiseInfos) {
		this.msgPraiseInfos = msgPraiseInfos;
	}

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}
	
	
}
