package com.uhutu.sportcenter.z.result;

import com.uhutu.dcom.extend.sensitive.z.entity.CnStartUp;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiStartUpResult extends RootApiResult {

	@ApiModelProperty(name = "启动页信息")
	private CnStartUp startUp = new CnStartUp();

	public CnStartUp getStartUp() {
		return startUp;
	}

	public void setStartUp(CnStartUp startUp) {
		this.startUp = startUp;
	}

}
