package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentDetailInfo;
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
	private ContentBasicinfoForApi sportingMoment = new ContentBasicinfoForApi();
	
	@ApiModelProperty(value="内容详细信息",notes="详细信息")
	private ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

	public ContentBasicinfoForApi getSportingMoment() {
		return sportingMoment;
	}

	public void setSportingMoment(ContentBasicinfoForApi sportingMoment) {
		this.sportingMoment = sportingMoment;
	}

	public ContentDetailInfo getContentDetailInfo() {
		return contentDetailInfo;
	}

	public void setContentDetailInfo(ContentDetailInfo contentDetailInfo) {
		this.contentDetailInfo = contentDetailInfo;
	}

}
