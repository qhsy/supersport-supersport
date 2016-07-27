package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户内容信息tab
 * @author 逄小帅
 *
 */
public class UserContentTabInfo {
	

	
	@ApiModelProperty(value="是否还有下页数据")
	private boolean nextflag = false;
	
	@ApiModelProperty(value="运动时刻")
	private List<ContentBasicinfoForApi> contentInfos = new ArrayList<ContentBasicinfoForApi>();

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

	public List<ContentBasicinfoForApi> getContentInfos() {
		return contentInfos;
	}

	public void setContentInfos(List<ContentBasicinfoForApi> contentInfos) {
		this.contentInfos = contentInfos;
	}



}
