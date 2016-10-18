package com.uhutu.sportcenter.z.entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 贴纸
 * 
 * @author xiegj
 *
 */
@ApiModel
public class PicPasterInfo extends BaseEntity {

	@ApiModelProperty(name = "贴纸编号", notes = "贴纸编号")
	private String code;

	@ApiModelProperty(name = "标题", notes = "标题")
	private String name;

	@ApiModelProperty(name = "贴纸", notes = "贴纸")
	private String cover;

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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
