package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiForTecentSigResult extends RootApiResult {

	@ApiModelProperty(value = "sig信息")
	private String sig;


	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

}
