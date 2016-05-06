package com.uhutu.sportcenter.z.entity;

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
public class SportCategoryForApi extends BaseEntity {

	@ApiModelProperty(value = "运动编号", notes = "运动编号")
	private String code = "";

	@ApiModelProperty(value = "运动名称", notes = "运动名称")
	private String name = "";

	@ApiModelProperty(value = "运动图片链接", notes = "运动图片链接")
	private String icon = "";

	@ApiModelProperty(value = "描述", notes = "描述")
	private String description = "";

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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
