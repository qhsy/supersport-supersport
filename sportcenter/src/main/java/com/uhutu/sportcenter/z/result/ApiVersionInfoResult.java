package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiVersionInfoResult extends RootApiResult {

	@ApiModelProperty(value = "升级方式", notes = "参数说明：dzsd4107100210020001:代表调用失败，dzsd4107100210020002:代表强制升级，dzsd4107100210020003:代表不强制升级,dzsd4107100210020004:代表静默升级,dzsd4107100210020005:代表不用升级")
	private String upgradeType = "3";
	@ApiModelProperty(value = "升级版本号", notes = "用户设定升级到的版本号")
	private String versionNo = "";
	@ApiModelProperty(value = "升级内容", notes = "升级内容信息描述")
	private String upgradeContent = "";
	@ApiModelProperty(value = "app地址")
	private String appUrl = "";

	public String getUpgradeType() {
		return upgradeType;
	}

	public void setUpgradeType(String upgradeType) {
		this.upgradeType = upgradeType;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getUpgradeContent() {
		return upgradeContent;
	}

	public void setUpgradeContent(String upgradeContent) {
		this.upgradeContent = upgradeContent;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

}
