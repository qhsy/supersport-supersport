package com.uhutu.sportcenter.api.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiVersionInfoResult  extends RootApiResult{
	
	@ApiModelProperty(value="升级方式",notes="参数说明：0、代表调用失败，1、代表强制升级，2、代表不强制升级，3、代表不用升级，4、代表静默升级")
	private  String  upgradeSelect ="";
	@ApiModelProperty(value="升级版本号",notes="用户设定升级到的版本号")
	private  String  appVersion ="";
	@ApiModelProperty(value="升级内容",notes="升级内容信息描述")
	private  String  upgradeContent="";
	@ApiModelProperty(value="ios Appstore地址",notes="如果后台系统没有配置相应的数据，该字段为null,该字段只为ios提供")
	private  String  iosAppUrl="";
	@ApiModelProperty(value="安卓文件地址",notes="如果后台系统没有配置相应的数据，该字段为null,该字段只为andriod提供")
	private String androidAppUrl = "";
	public String getUpgradeSelect() {
		return upgradeSelect;
	}
	public void setUpgradeSelect(String upgradeSelect) {
		this.upgradeSelect = upgradeSelect;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getUpgradeContent() {
		return upgradeContent;
	}
	public void setUpgradeContent(String upgradeContent) {
		this.upgradeContent = upgradeContent;
	}
	public String getIosAppUrl() {
		return iosAppUrl;
	}
	public void setIosAppUrl(String iosAppUrl) {
		this.iosAppUrl = iosAppUrl;
	}
	public String getAndroidAppUrl() {
		return androidAppUrl;
	}
	public void setAndroidAppUrl(String androidAppUrl) {
		this.androidAppUrl = androidAppUrl;
	}

}
