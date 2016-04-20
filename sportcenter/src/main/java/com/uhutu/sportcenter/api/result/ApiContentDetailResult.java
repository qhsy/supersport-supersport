package com.uhutu.sportcenter.api.result;

import com.uhutu.sportcenter.api.entity.ContentDetailInfo;
import com.uhutu.sportcenter.api.entity.SportingMoment;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详情
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiContentDetailResult extends RootApiResult {
	
	@ApiModelProperty(value="内容基本信息",notes="基本信息")
	private SportingMoment sportingMoment = new SportingMoment();
	
	@ApiModelProperty(value="内容详细信息",notes="详细信息")
	private ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

	public SportingMoment getSportingMoment() {
		return sportingMoment;
	}

	public void setSportingMoment(SportingMoment sportingMoment) {
		this.sportingMoment = sportingMoment;
	}

	public ContentDetailInfo getContentDetailInfo() {
		return contentDetailInfo;
	}

	public void setContentDetailInfo(ContentDetailInfo contentDetailInfo) {
		this.contentDetailInfo = contentDetailInfo;
	}

}
