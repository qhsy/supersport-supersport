package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容信息数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentDetail extends BaseEntity{

	@ZooData(name = "分类编号")
	private String code;
	
	@ZooData(name = "内容信息json串")
	private String content;

	@ZooData(name = "内容简述")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}