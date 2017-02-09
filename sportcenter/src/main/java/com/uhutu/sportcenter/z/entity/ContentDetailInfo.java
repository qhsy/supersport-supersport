package com.uhutu.sportcenter.z.entity;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详细信息
 * @author pang_jhui
 *
 */
public class ContentDetailInfo {
	
	@ApiModelProperty(name="内容编号" ,notes="内容编号")
	private String code="";
	
	@ApiModelProperty(name="内容" ,notes="内容")
	private String content;
	
	@ApiModelProperty(name="简介",notes="简介")
	private String description = "";
	
	@ApiModelProperty(name="视频路径")
	private String videoUrl;
	
	@ApiModelProperty(name="视频封面")
	private String videoCover;
	
	@ApiModelProperty(value = "打赏人数")
	private int redPackNum;

	@ApiModelProperty(value = "打赏人员列表")
	private List<UserBasicInfo> redPackUsers;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getVideoCover() {
		return videoCover;
	}

	public void setVideoCover(String videoCover) {
		this.videoCover = videoCover;
	}

	public int getRedPackNum() {
		return redPackNum;
	}

	public void setRedPackNum(int redPackNum) {
		this.redPackNum = redPackNum;
	}

	public List<UserBasicInfo> getRedPackUsers() {
		return redPackUsers;
	}

	public void setRedPackUsers(List<UserBasicInfo> redPackUsers) {
		this.redPackUsers = redPackUsers;
	}

}
