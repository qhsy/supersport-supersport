package com.uhutu.dcom.extend.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 报表限制参数表
 * 
 * @author xiegj
 *
 */
@Entity
public class ReReportLimit extends BaseEntity {

	@ZooData(name = "报表编号")
	private String code;

	@ZooData(name = "限制字段")
	private String fieldCode;

	@ZooData(name = "字段限制值")
	private String fieldLimit;

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

	public String getFieldLimit() {
		return fieldLimit;
	}

	public void setFieldLimit(String fieldLimit) {
		this.fieldLimit = fieldLimit;
	}

}
