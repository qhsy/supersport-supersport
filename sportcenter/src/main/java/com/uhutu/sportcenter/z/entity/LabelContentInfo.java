package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 标签内容信息
 * @author 逄小帅
 *
 */
public class LabelContentInfo {
	
	@ApiModelProperty(value="是否还有下页数据")
	private boolean nextflag = false;
	
	@ApiModelProperty(value="内容列表信息")
	private List<ContentBasicinfoForApi> contentBasicInfos = new ArrayList<ContentBasicinfoForApi>();

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

	public List<ContentBasicinfoForApi> getContentBasicInfos() {
		return contentBasicInfos;
	}

	public void setContentBasicInfos(List<ContentBasicinfoForApi> contentBasicInfos) {
		this.contentBasicInfos = contentBasicInfos;
	}

}
