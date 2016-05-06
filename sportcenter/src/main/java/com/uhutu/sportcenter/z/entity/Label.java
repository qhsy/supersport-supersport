package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

public class Label{

	@ApiModelProperty(name="标签编号" ,notes="标签编号",example="lb001")
	private String code="";
	
	@ApiModelProperty(name="标签" ,notes="标签",example="极限运动")
	private String name="";
	
	@ApiModelProperty(name="位置经纬度" ,notes="位置经纬度",example="123456,456789")
	private String location="";
	
	@ApiModelProperty(name="位置名称" ,notes="位置名称",example="金域国际大厦")
	private String locationName="";

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

}
