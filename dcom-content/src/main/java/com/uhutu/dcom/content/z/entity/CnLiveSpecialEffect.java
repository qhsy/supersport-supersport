package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播特效基本信息表
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class CnLiveSpecialEffect extends BaseEntity {

	@ZooData(name = "特效编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "特效名称", require = "1")
	private String name;

	@ZooData(name = "类型", element = DefineWebElement.Select, sort = { DefineWebPage.Page_Edit + "=0" }, inc = {
			DefineWebInc.System_Define + "=dzsd410710011019" })
	private String type;

	@ZooData(name = "状态 ", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011020" })
	private String status;

	@ZooData(name = "位置(倒序)", element = DefineWebElement.Input, verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0" }, require = "1")
	private int sort = 0;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
