package com.uhutu.sportcenter.api.input;

import com.uhutu.sportcenter.api.entity.SportingMoment;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiPublishSportingMomentInput extends RootApiInput {

	@ApiModelProperty(value = "运动时刻信息")
	private SportingMoment moment = new SportingMoment();

	public SportingMoment getMoment() {
		return moment;
	}

	public void setMoment(SportingMoment moment) {
		this.moment = moment;
	}

}
