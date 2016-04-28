package com.uhutu.sportcenter.api.entity;

import javax.persistence.Entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 运动数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class ContentSportForApi extends BaseEntity {

	@ApiModelProperty(value = "运动编号", notes = "运动编号")
	private String code = "";

	@ApiModelProperty(value = "运动名称", notes = "运动名称")
	private String name = "";

	@ApiModelProperty(value = "运动图片链接", notes = "运动图片链接")
	private String picUrl = "";

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
