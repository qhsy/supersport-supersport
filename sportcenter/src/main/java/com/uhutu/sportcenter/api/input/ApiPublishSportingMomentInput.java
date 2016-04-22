package com.uhutu.sportcenter.api.input;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiPublishSportingMomentInput extends RootApiInput {

	@ApiModelProperty(value = "运动时刻信息")
	private CnContentBasicinfo moment = new CnContentBasicinfo();

	public CnContentBasicinfo getMoment() {
		return moment;
	}

	public void setMoment(CnContentBasicinfo moment) {
		this.moment = moment;
	}

}
