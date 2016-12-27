package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事信息
 * @author 逄小帅
 *
 */
public class MatchInfo {
	
	@ApiModelProperty(value="举办者信息")
	private UserBasicInfo userBasicInfo = new UserBasicInfo();
	
	@ApiModelProperty(value="赛事编号")
	private String code;
	
	@ApiModelProperty(value="举办地点")
	private String place;
	
	@ApiModelProperty(value="开始时间")
	private String startTime;
	
	@ApiModelProperty(value="结束时间")
	private String endTime;	
	
	@ApiModelProperty(value="封面图")
	private String cover;
	
	@ApiModelProperty(value="赛事标识")
	private String flag;
	
	@ApiModelProperty(value="赛事名称")
	private String name;
	
	@ApiModelProperty(value="赛事详情")
	private List<String> details = new ArrayList<String>();

	public UserBasicInfo getUserBasicInfo() {
		return userBasicInfo;
	}

	public void setUserBasicInfo(UserBasicInfo userBasicInfo) {
		this.userBasicInfo = userBasicInfo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
