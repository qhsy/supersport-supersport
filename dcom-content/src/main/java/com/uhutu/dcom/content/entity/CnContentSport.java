package com.uhutu.dcom.content.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 运动数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentSport extends BaseEntity{

	@ZooData(name = "运动编号")
	private String code;
	
	@ZooData(name = "运动名称")
	private String name;

	@ZooData(name = "运动图片")
	private String picUrl;

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

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
