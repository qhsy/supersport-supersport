package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentItemForApi;
import com.uhutu.dcom.content.z.entity.CnHomeNavMenuForApi;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageSecond {

	@ApiModelProperty(name = "栏目类型", notes = "dzsd4107100110060001:轮播广告,dzsd4107100110060002:单图广告,dzsd4107100110060003:内容,"
			+ "dzsd4107100110060004:时间展示,dzsd4107100110060005:一栏内容,dzsd4107100110060006:两栏内容1:1,"
			+ "dzsd4107100110060007:两栏内容4:3,dzsd4107100110060008:三栏内容,dzsd4107100110060009:导航栏", example = "dzsd4107100110060001")
	private String showType = "";

	@ApiModelProperty(name = "栏目信息", notes = "栏目信息", example = "栏目信息")
	private CnContentItemForApi item = new CnContentItemForApi();

	@ApiModelProperty(name = "内容信息", notes = "内容信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	List<ContentBasicinfoForApi> infos = new ArrayList<ContentBasicinfoForApi>();

	@ApiModelProperty(name = "导航栏信息")
	List<CnHomeNavMenuForApi> navs = new ArrayList<CnHomeNavMenuForApi>();

	@ApiModelProperty(name = "广告信息", notes = "广告信息")
	private AdvertiseMent adv = new AdvertiseMent();

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public List<ContentBasicinfoForApi> getInfos() {
		return infos;
	}

	public void setInfos(List<ContentBasicinfoForApi> infos) {
		this.infos = infos;
	}

	public CnContentItemForApi getItem() {
		return item;
	}

	public void setItem(CnContentItemForApi item) {
		this.item = item;
	}

	public List<CnHomeNavMenuForApi> getNavs() {
		return navs;
	}

	public void setNavs(List<CnHomeNavMenuForApi> navs) {
		this.navs = navs;
	}

	public AdvertiseMent getAdv() {
		return adv;
	}

	public void setAdv(AdvertiseMent adv) {
		this.adv = adv;
	}

}
