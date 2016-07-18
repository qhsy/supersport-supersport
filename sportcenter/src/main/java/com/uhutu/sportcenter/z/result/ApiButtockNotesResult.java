package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 翘臀大赛
 * @author jack
 *
 */
@ApiModel
public class ApiButtockNotesResult extends RootApiResult {
	
	@ApiModelProperty(value="活动须知")
	private String notes = "";

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
