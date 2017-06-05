package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 积分流水
 * 
 */
@Entity
public class CnPointRoles extends BaseEntity {

	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=JFLXBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "积分类型名称")
	private String name;
	
	@ZooData(name = "单次积分")
	private int point;

	@ZooData(name = "积分上限")
	private int limitPoint;

	@ZooData(value = "规则", element = DefineWebElement.Checkbox, inc = { DefineWebInc.Source_Code + "=dzsi46991001",
			DefineWebInc.Source_Value + "=dzsd480110011001" }, sort = { DefineWebPage.Page_Query + "=0" })
	private String roles;

	@ZooData(name = "备注")
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getLimitPoint() {
		return limitPoint;
	}

	public void setLimitPoint(int limitPoint) {
		this.limitPoint = limitPoint;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	

}
