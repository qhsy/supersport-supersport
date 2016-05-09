package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentPhotosDetail;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiContentPhotosResult extends RootApiResult {
	
	@ApiModelProperty(value="图集总数")
	private int totalCount;
	
	@ApiModelProperty(value="内容基本信息",notes="基本信息")
	private ContentBasicinfoForApi contentBasicInfo = new ContentBasicinfoForApi();
	
	@ApiModelProperty(value="内容详细信息",notes="详细信息")
	private List<ContentPhotosDetail> contentPhotosDetails = new ArrayList<ContentPhotosDetail>();

	public ContentBasicinfoForApi getContentBasicInfo() {
		return contentBasicInfo;
	}

	public void setContentBasicInfo(ContentBasicinfoForApi contentBasicInfo) {
		this.contentBasicInfo = contentBasicInfo;
	}

	public List<ContentPhotosDetail> getContentPhotosDetails() {
		return contentPhotosDetails;
	}

	public void setContentPhotosDetails(List<ContentPhotosDetail> contentPhotosDetails) {
		this.contentPhotosDetails = contentPhotosDetails;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	

}
