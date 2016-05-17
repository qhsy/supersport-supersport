package com.uhutu.dcom.tag.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel
public class CnContentLabel extends BaseEntity {

	@ZooData(name = "标签编号", inc = DefineWebInc.Insert_Code + "=GGBH", sort = { DefineWebPage.Page_Add + "=35",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "标签名称")
	private String name;

	@ZooData(name = "账户类型", sort = { DefineWebPage.Page_Query + "=0" })
	private String type;

	@ZooData(name = "位置经纬度", sort = { DefineWebPage.Page_Query + "=0" })
	private String location;

	@ZooData(name = "位置名称")
	private String locationName;

	@ZooData(name = "状态(是否可用)", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
