package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.MsgNumInfo;
import com.uhutu.zoocom.root.RootApiResult;

import java.util.ArrayList;
import java.util.List;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息中心数量结果
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgNumListResult extends RootApiResult {
	
	@ApiModelProperty(name = "消息数量列表", notes = "消息数量列表")
	List<MsgNumInfo> msgNumInfos = new ArrayList<MsgNumInfo>();

	public List<MsgNumInfo> getMsgNumInfos() {
		return msgNumInfos;
	}

	public void setMsgNumInfos(List<MsgNumInfo> msgNumInfos) {
		this.msgNumInfos = msgNumInfos;
	}	

}
