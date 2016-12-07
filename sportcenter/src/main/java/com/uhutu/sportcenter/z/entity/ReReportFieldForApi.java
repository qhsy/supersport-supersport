package com.uhutu.sportcenter.z.entity;

import com.uhutu.dcom.extend.z.entity.ReFieldType;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报表字段表
 * 
 * @author xiegj
 *
 */
public class ReReportFieldForApi extends BaseEntity {

	@ApiModelProperty(name = "报表编号")
	private String code;

	@ApiModelProperty(name = "字段编号")
	private String fieldCode;

	@ApiModelProperty(name = "字段名称")
	private String fieldName;

	@ApiModelProperty(name = "字段类型编号")
	private String fieldType;

	@ApiModelProperty(name = "可重复使用次数")
	private int num;

	@ApiModelProperty(name = "字段取值范围")
	private String scope;

	@ApiModelProperty(name = "展示顺序")
	private int showSort;

	@ApiModelProperty(name = "字段类型相关")
	private ReFieldType type = new ReFieldType();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFieldCode() {
		return fieldCode;
	}

	public void setFieldCode(String fieldCode) {
		this.fieldCode = fieldCode;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public int getShowSort() {
		return showSort;
	}

	public void setShowSort(int showSort) {
		this.showSort = showSort;
	}

	public ReFieldType getType() {
		return type;
	}

	public void setType(ReFieldType type) {
		this.type = type;
	}

}
