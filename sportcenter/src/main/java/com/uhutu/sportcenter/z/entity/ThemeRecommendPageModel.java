package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class ThemeRecommendPageModel {

	@ApiModelProperty(name = "标题")
	private String title = "";

	@ApiModelProperty(name = "推荐达人")
	List<RecommExpertInfo> recomms = new ArrayList<RecommExpertInfo>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<RecommExpertInfo> getRecomms() {
		return recomms;
	}

	public void setRecomms(List<RecommExpertInfo> recomms) {
		this.recomms = recomms;
	}

}
