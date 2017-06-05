package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiChooseMatchInput extends RootApiInput {

	@ApiModelProperty(value = "直播编号", required = true)
	private String code;

	@ApiModelProperty(value = "比赛球队编号", required = true)
	private String gameCode;

	@ApiModelProperty(value = "经度")
	private double longitude;

	@ApiModelProperty(value = "维度")
	private double latitude;

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

}
