package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.user.z.entity.UcSignPrice;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiCheckSingTypeResult extends RootApiResult {

	@ApiModelProperty(value = "已报满类型及价格 ")
	private List<UcSignPrice> alList = new ArrayList<UcSignPrice>();

	@ApiModelProperty(value = "可报名类型及价格 ")
	private List<UcSignPrice> yesList = new ArrayList<UcSignPrice>();

	@ApiModelProperty(value = "不可报名类型及价格 ")
	private List<UcSignPrice> noList = new ArrayList<UcSignPrice>();

	public List<UcSignPrice> getAlList() {
		return alList;
	}

	public void setAlList(List<UcSignPrice> alList) {
		this.alList = alList;
	}

	public List<UcSignPrice> getYesList() {
		return yesList;
	}

	public void setYesList(List<UcSignPrice> yesList) {
		this.yesList = yesList;
	}

	public List<UcSignPrice> getNoList() {
		return noList;
	}

	public void setNoList(List<UcSignPrice> noList) {
		this.noList = noList;
	}

}
