package com.uhutu.sportcenter.z.entity;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.zoocom.helper.DateHelper;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事直播信息
 * @author 逄小帅
 *
 */
public class MatchLiveInfo {
	
	@ApiModelProperty(value="直播编号")
	private String liveCode;
	
	@ApiModelProperty(value="直播状态")
	private String status;
	
	@ApiModelProperty(value="直播状态name")
	private String statusName;
	
	@ApiModelProperty(value="直播开始时间")
	private String startTime;
	
	@ApiModelProperty(value="直播标题")
	private String content;
	
	@ApiModelProperty(value="赛事编号")
	private String matchCode;
	
	@ApiModelProperty(value="跳转数据")
	private JumpTypeData jumpTypeData;

	public String getLiveCode() {
		return liveCode;
	}

	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartTime() {
		
		if(StringUtils.isNotEmpty(startTime)){
			
			Date startDate = DateHelper.parseDate(startTime);
			
			if(startDate != null){
				
				startTime = DateHelper.upDate(startDate,"yyyy-MM-dd HH:mm");
				
			}
			
		}
		
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public JumpTypeData getJumpTypeData() {
		return jumpTypeData;
	}

	public void setJumpTypeData(JumpTypeData jumpTypeData) {
		this.jumpTypeData = jumpTypeData;
	}

}
