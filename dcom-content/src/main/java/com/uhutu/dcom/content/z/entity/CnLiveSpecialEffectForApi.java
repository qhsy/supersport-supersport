package com.uhutu.dcom.content.z.entity;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 直播特效
 * 
 * @author xiegj
 *
 */
public class CnLiveSpecialEffectForApi extends BaseEntity {

	@ApiModelProperty(name = "特效编号")
	private String code;

	@ApiModelProperty(name = "特效名称")
	private String name;

	@ApiModelProperty(name = "类型", value = "dzsd4107100110190001:左到右直线滑动,dzsd4107100110190002:放大淡出,dzsd4107100110190003:抛物线滑动")
	private String type;

	@ApiModelProperty(name = "免费次数 ")
	private int num;

	@ApiModelProperty(name = "位置(倒序)")
	private int sort = 0;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
