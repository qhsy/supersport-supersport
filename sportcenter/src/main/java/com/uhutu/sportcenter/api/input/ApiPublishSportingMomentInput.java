package com.uhutu.sportcenter.api.input;

import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.api.entity.ContentDetailInfo;
import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModelProperty;

public class ApiPublishSportingMomentInput extends RootApiInput {

	@ApiModelProperty(value = "运动时刻信息")
	private ContentBasicinfoForApi moment = new ContentBasicinfoForApi();
	
	@ApiModelProperty(value = "运动时刻详细信息")
	private ContentDetailInfo momentDetailInfo = new ContentDetailInfo();

	public ContentBasicinfoForApi getMoment() {
		return moment;
	}

	public void setMoment(ContentBasicinfoForApi moment) {
		this.moment = moment;
	}

	public ContentDetailInfo getMomentDetailInfo() {
		return momentDetailInfo;
	}

	public void setMomentDetailInfo(ContentDetailInfo momentDetailInfo) {
		this.momentDetailInfo = momentDetailInfo;
	}

}
