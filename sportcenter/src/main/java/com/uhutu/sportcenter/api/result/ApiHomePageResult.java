package com.uhutu.sportcenter.api.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.api.entity.AdvertiseMent;
import com.uhutu.sportcenter.api.entity.HomePageModel;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiHomePageResult extends RootApiResult {
	
	@ApiModelProperty(name="首页展示实体数组" ,notes="首页展示实体数组",example="01")
	private List<HomePageModel>	list=	new  ArrayList<HomePageModel>();

	@ApiModelProperty(name="首页顶部广告位" ,notes="首页顶部广告位")
	private AdvertiseMent	adv = new AdvertiseMent();
	
	public List<HomePageModel> getList() {
		return list;
	}

	public void setList(List<HomePageModel> list) {
		this.list = list;
	}

	public AdvertiseMent getAdv() {
		return adv;
	}

	public void setAdv(AdvertiseMent adv) {
		this.adv = adv;
	}

}
