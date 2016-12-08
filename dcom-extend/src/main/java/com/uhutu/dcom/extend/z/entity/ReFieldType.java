package com.uhutu.dcom.extend.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 字段类型表
 * 
 * @author xiegj
 *
 */
@Entity
public class ReFieldType extends BaseEntity {
	@ApiModelProperty(name = "字段类型编号")
	@ZooData(name = "字段类型编号")
	private String code;

	@ApiModelProperty(name = "字段类型简写")
	@ZooData(name = "字段类型简写")
	private String name;

	@ApiModelProperty(name = "字段值校验公式")
	@ZooData(name = "字段值校验公式")
	private String checkRole;

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

	public String getCheckRole() {
		return checkRole;
	}

	public void setCheckRole(String checkRole) {
		this.checkRole = checkRole;
	}

}
