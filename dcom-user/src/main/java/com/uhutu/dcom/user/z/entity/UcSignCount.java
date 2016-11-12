package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名数量信息表
 * 
 * @author xiegj
 *
 */
@Entity
public class UcSignCount extends BaseEntity {

	@ApiModelProperty(value = "参赛类型: dzsd4107100510030001:个人,dzsd4107100510030002:团体")
	@ZooData(name = "参赛类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710051003" }, require = "1")
	@Column(length = 50)
	private String type;

	@ApiModelProperty(value = "可报名数")
	@ZooData(name = "可报名数", require = "1")
	private int count;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
