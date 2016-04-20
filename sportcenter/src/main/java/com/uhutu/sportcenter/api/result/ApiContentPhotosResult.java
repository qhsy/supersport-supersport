package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.api.entity.ContentPhotosDetail;
import com.uhutu.sportcenter.api.entity.SportingMoment;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiContentPhotosResult extends RootApiResult {
	
	@ApiModelProperty(value="内容基本信息",notes="基本信息")
	private SportingMoment sportingMoment = new SportingMoment();
	
	@ApiModelProperty(value="内容详细信息",notes="详细信息")
	private List<ContentPhotosDetail> contentPhotosDetails = new ArrayList<ContentPhotosDetail>();

	public SportingMoment getSportingMoment() {
		return sportingMoment;
	}

	public void setSportingMoment(SportingMoment sportingMoment) {
		this.sportingMoment = sportingMoment;
	}

	public List<ContentPhotosDetail> getContentPhotosDetails() {
		return contentPhotosDetails;
	}

	public void setContentPhotosDetails(List<ContentPhotosDetail> contentPhotosDetails) {
		this.contentPhotosDetails = contentPhotosDetails;
	}

	

}
