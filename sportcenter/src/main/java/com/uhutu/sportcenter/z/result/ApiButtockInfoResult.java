package com.uhutu.sportcenter.z.result;

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
	
	@ApiModelProperty(value="实力派")
	private ButtockInfo buttockPower = new ButtockInfo();

	@ApiModelProperty(value="翘丽圈")
	private ButtockInfo buttockLap = new ButtockInfo();

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ButtockInfo getButtockPower() {
		return buttockPower;
	}

	public void setButtockPower(ButtockInfo buttockPower) {
		this.buttockPower = buttockPower;
	}

	public ButtockInfo getButtockLap() {
		return buttockLap;
	}

	public void setButtockLap(ButtockInfo buttockLap) {
		this.buttockLap = buttockLap;
	}
	
}
