package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageModel {

	@ApiModelProperty(name = "展示类型", notes = "dzsd4107100110060001:轮播广告,dzsd4107100110060002:单图广告,dzsd4107100110060003:内容,dzsd4107100110060004:时间展示", example = "dzsd4107100110060001")
	private String showType = "";
	
	@ApiModelProperty(name = "用户信息", notes = "用户信息头像昵称等信息", example = "张嘉译个人信息")
	UserinfoExtForApi ue = new UserinfoExtForApi();

	@ApiModelProperty(name = "内容信息", notes = "内容信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	ContentBasicinfoForApi info = new ContentBasicinfoForApi();

	@ApiModelProperty(name = "广告信息", notes = "广告信息")
	private AdvertiseMent adv = new AdvertiseMent();

	@ApiModelProperty(name = "日期展示信息", notes = "日期展示信息")
	private String dateShow = "";

	public UserinfoExtForApi getUe() {
		return ue;
	}

	public void setUe(UserinfoExtForApi ue) {
		this.ue = ue;
	}

	public ContentBasicinfoForApi getInfo() {
		return info;
	}

	public void setInfo(ContentBasicinfoForApi info) {
		this.info = info;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public AdvertiseMent getAdv() {
		return adv;
	}

	public void setAdv(AdvertiseMent adv) {
		this.adv = adv;
	}

	public String getDateShow() {
		return dateShow;
	}

	public void setDateShow(String dateShow) {
		this.dateShow = dateShow;
	}

}
