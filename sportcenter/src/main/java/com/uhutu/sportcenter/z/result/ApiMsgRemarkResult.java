package com.uhutu.sportcenter.z.result;

import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentReplyInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户消息中心评论结果
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgRemarkResult extends RootApiResult {
	
	@ApiModelProperty(value="评论信息")
	private List<ContentReplyInfo> contentRemarkInfo;
	
	@ApiModelProperty(value="是否还有下一页")
	private boolean nextflag = false;

	public List<ContentReplyInfo> getContentRemarkInfo() {
		return contentRemarkInfo;
	}

	public void setContentRemarkInfo(List<ContentReplyInfo> contentRemarkInfo) {
		this.contentRemarkInfo = contentRemarkInfo;
	}

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}
	
}
