package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 运动类型数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class SpSportCategory extends BaseEntity{

	@ZooData(name = "运动类型编号")
	private String code;
	
	@ZooData(name = "运动类型名称")
	private String name;

	@ZooData(name = "运动类型描述")
	private String description;


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
