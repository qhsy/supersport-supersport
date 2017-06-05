package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.CnMaterialLibrary;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageModel {

	@ApiModelProperty(name = "展示类型", notes = "dzsd4107100110060001:推荐栏,dzsd4107100110060002:直播预告栏", example = "dzsd4107100110060001")
	private String showType = "";

	@ApiModelProperty(name = "直播信息", notes = "直播信息", example = "")
	List<ContentBasicinfoForApi> lives = new ArrayList<ContentBasicinfoForApi>();

	@ApiModelProperty(name = "视频信息", notes = "视频信息", example = "")
	List<ContentBasicinfoForApi> videos = new ArrayList<ContentBasicinfoForApi>();

	@ApiModelProperty(name = "推荐信息", notes = "推荐信息", example = "")
	List<CnMaterialLibrary> topics = new ArrayList<CnMaterialLibrary>();
	
	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public List<ContentBasicinfoForApi> getLives() {
		return lives;
	}

	public void setLives(List<ContentBasicinfoForApi> lives) {
		this.lives = lives;
	}

	public List<ContentBasicinfoForApi> getVideos() {
		return videos;
	}

	public void setVideos(List<ContentBasicinfoForApi> videos) {
		this.videos = videos;
	}

	public List<CnMaterialLibrary> getTopics() {
		return topics;
	}

	public void setTopics(List<CnMaterialLibrary> topics) {
		this.topics = topics;
	}

}
