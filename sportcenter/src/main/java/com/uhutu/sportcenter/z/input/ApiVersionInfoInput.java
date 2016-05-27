package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class ApiVersionInfoInput  extends RootApiInput  {

	@ApiModelProperty(value="手机系统类型",notes="对应手机当前手机类型，如：1代表ios,2代表andriod",required=true)
	private String systemType = "";
	@ApiModelProperty(value="版本号",notes="对应App版本添加时的版本号，区分大小写。如：V1.0、V1.1、V1.3等",required=true)
	private String versionNo = "";
	
	public String getSystemType() {
		return systemType;
	}
	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}
	public String getVersionNo() {
		return versionNo;
	}
	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}
	
	
}
