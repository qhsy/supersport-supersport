package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ButtockInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 翘臀大赛信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiButtockInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="活动须知")
	private String notes;

	@ApiModelProperty(value="翘臀活动信息")
	private List<ButtockInfo> buttockInfos = new ArrayList<ButtockInfo>();
	
	@ApiModelProperty(value="报名连接")
	private String applyUrl;

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<ButtockInfo> getButtockInfos() {
		return buttockInfos;
	}

	public void setButtockInfos(List<ButtockInfo> buttockInfos) {
		this.buttockInfos = buttockInfos;
	}

	public String getApplyUrl() {
		return applyUrl;
	}

	public void setApplyUrl(String applyUrl) {
		this.applyUrl = applyUrl;
	}
	
}
