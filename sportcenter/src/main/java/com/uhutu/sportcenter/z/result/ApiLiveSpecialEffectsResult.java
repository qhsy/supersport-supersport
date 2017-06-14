package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.CnLiveSpecialEffectForApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveSpecialEffectsResult extends RootApiResult {

	@ApiModelProperty(value = "特效信息")
	List<CnLiveSpecialEffectForApi> lse = new ArrayList<CnLiveSpecialEffectForApi>();

	public List<CnLiveSpecialEffectForApi> getLse() {
		return lse;
	}

	public void setLse(List<CnLiveSpecialEffectForApi> lse) {
		this.lse = lse;
	}

}
