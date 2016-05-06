package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 栏目数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentItem extends BaseEntity{

	@ZooData(name = "栏目编号")
	private String code;
	
	@ZooData(name = "栏目名称")
	private String name;


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

}
