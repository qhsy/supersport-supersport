package com.uhutu.sportcenter.z.entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播比赛队伍关联关系
 * 
 *
 */
public class CnLiveMatchLogForApi extends BaseEntity {

	@ApiModelProperty(name = "直播名称")
	private String code;

	@ApiModelProperty(name = "球队名称")
	private String gameCode;

	@ApiModelProperty(name = "用户昵称")
	private String userCode;

	@ApiModelProperty(value = "经度")
	private double longitude;

	@ApiModelProperty(value = "维度")
	private double latitude;

	@ApiModelProperty(value = "距离(直接显示即可  已拼装好m或者km)")
	private String distance;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

}
