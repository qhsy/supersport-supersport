package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 分类数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentCategory extends BaseEntity{

	@ZooData(name = "分类编号")
	private String code;
	
	@ZooData(name = "分类编号")
	private String name;

	@ZooData(name = "分类父编号")
	private String parentCode;

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

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
}
