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
public class ThemePageModel {

	@ApiModelProperty(name = "专题栏目标题")
	private String title = "";

	@ApiModelProperty(name = "内容信息", notes = "内容信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	List<ContentBasicinfoForApi> infos = new ArrayList<ContentBasicinfoForApi>();

	@ApiModelProperty(name = "推荐达人")
	List<RecommExpertInfo> recomms = new ArrayList<RecommExpertInfo>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ContentBasicinfoForApi> getInfos() {
		return infos;
	}

	public void setInfos(List<ContentBasicinfoForApi> infos) {
		this.infos = infos;
	}

	public List<RecommExpertInfo> getRecomms() {
		return recomms;
	}

	public void setRecomms(List<RecommExpertInfo> recomms) {
		this.recomms = recomms;
	}

}
