package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.CnLiveMatchLogForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiFriendsNearbyResult extends RootApiResult {

	@ApiModelProperty(value = "数据集")
	List<CnLiveMatchLogForApi> fs = new ArrayList<CnLiveMatchLogForApi>();

	@ApiModelProperty(value = "是否还有下一页数据")
	private boolean nextPage = false;

	@ApiModelProperty(value = "附近共有多少人")
	private int nearbyNum = 0;

	@ApiModelProperty(value = "同阵营有多少人")
	private int sameCampNum = 0;

	@ApiModelProperty(value = "对方阵营有多少人")
	private int otherCampNum = 0;

	public List<CnLiveMatchLogForApi> getFs() {
		return fs;
	}

	public void setFs(List<CnLiveMatchLogForApi> fs) {
		this.fs = fs;
	}

	public boolean isNextPage() {
		return nextPage;
	}

	public void setNextPage(boolean nextPage) {
		this.nextPage = nextPage;
	}

	public int getNearbyNum() {
		return nearbyNum;
	}

	public void setNearbyNum(int nearbyNum) {
		this.nearbyNum = nearbyNum;
	}

	public int getSameCampNum() {
		return sameCampNum;
	}

	public void setSameCampNum(int sameCampNum) {
		this.sameCampNum = sameCampNum;
	}

	public int getOtherCampNum() {
		return otherCampNum;
	}

	public void setOtherCampNum(int otherCampNum) {
		this.otherCampNum = otherCampNum;
	}

}
