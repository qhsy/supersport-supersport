package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiSportChickenSoupResult extends RootApiResult {

	@ApiModelProperty(name = "运动时刻小知识")
	private String chickenSoup = "";

	public String getChickenSoup() {
		return chickenSoup;
	}

	public void setChickenSoup(String chickenSoup) {
		this.chickenSoup = chickenSoup;
	}

}
