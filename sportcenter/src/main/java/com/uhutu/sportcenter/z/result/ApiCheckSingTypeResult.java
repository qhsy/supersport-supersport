package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiCheckSingTypeResult extends RootApiResult {

	@ApiModelProperty(value = "可报名类型及价格 ")
	private List<UcSignPrice> list = new ArrayList<UcSignPrice>();

	public List<UcSignPrice> getList() {
		return list;
	}

	public void setList(List<UcSignPrice> list) {
		this.list = list;
	}
	
}
