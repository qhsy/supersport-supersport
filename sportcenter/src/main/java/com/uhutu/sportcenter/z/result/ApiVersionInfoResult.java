package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiVersionInfoResult extends RootApiResult {

	@ApiModelProperty(value = "升级方式", notes = "参数说明：0、代表调用失败，1、代表强制升级，2、代表不强制升级，3、代表不用升级，4、代表静默升级")
	private String upgradeType = "3";
	@ApiModelProperty(value = "升级版本号", notes = "用户设定升级到的版本号")
	private String versionNo = "";
	@ApiModelProperty(value = "升级内容", notes = "升级内容信息描述")
	private String upgradeContent = "";
	@ApiModelProperty(value = "ios Appstore地址", notes = "如果后台系统没有配置相应的数据，该字段为null,该字段只为ios提供")
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
