package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiSportingMomentsSecondResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	@ApiModelProperty(name="版块名称",value="版块名称",example="运动时刻")
	private String  	contentTitle= "";
	
	@ApiModelProperty(name="运动时刻列表",value="运动时刻列表",example="")
	private List<ContentBasicinfoForApi> moments  	=	new ArrayList<ContentBasicinfoForApi>();

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public List<ContentBasicinfoForApi> getMoments() {
		return moments;
	}

	public void setMoments(List<ContentBasicinfoForApi> moments) {
		this.moments = moments;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
