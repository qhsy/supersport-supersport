package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 我的报名信息
 * @author 逄小帅
 *
 */
public class MySignInfo {
	
	@ApiModelProperty(value="报名生成随机编号")
	private String code;
	
	@ApiModelProperty(value="报名信息关联编号")
	private String signCode;
	
	@ApiModelProperty(value="赛事封面")
	private String cover;
	
	@ApiModelProperty(value="报名标题")
	private String title;
	
	@ApiModelProperty(value="报名金额")
	private String money;
	
	@ApiModelProperty(value="报名开始时间")
	private String startTime;
	
	@ApiModelProperty(value="报名结束时间")
	private String endTime;
	
	@ApiModelProperty(value="赛事举办地")
	private String location;
	
	@ApiModelProperty(value="报名状态")
	private String status;

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

}
