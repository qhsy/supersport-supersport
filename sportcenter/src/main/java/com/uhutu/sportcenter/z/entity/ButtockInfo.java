package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ButtockInfo {
	
	@ApiModelProperty(value="标题")
	private String title;
	
	@ApiModelProperty(value="内容列表")
	private List<ContentBasicinfoForApi> contentInfos = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(value="是否还有下页数据")
	private boolean nextflag = false;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ContentBasicinfoForApi> getContentInfos() {
		return contentInfos;
	}

	public void setContentInfos(List<ContentBasicinfoForApi> contentInfos) {
		this.contentInfos = contentInfos;
	}

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

}
