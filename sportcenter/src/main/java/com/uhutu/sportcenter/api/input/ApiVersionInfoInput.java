package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModelProperty;

public class ApiVersionInfoInput  extends RootApiInput  {

	@ApiModelProperty(value="手机系统类型",notes="对应手机当前手机类型，如：1代表ios,2代表andriod")
	private String systemType = "";
	@ApiModelProperty(value="版本号",notes="对应App版本添加时的版本号，区分大小写。如：V1.0、V1.1、V1.3等",required=true)
	private String versionApp = "";
	
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getVersionApp() {
		return versionApp;
	}
	public void setVersionApp(String versionApp) {
		this.versionApp = versionApp;
	}
	
	
}
