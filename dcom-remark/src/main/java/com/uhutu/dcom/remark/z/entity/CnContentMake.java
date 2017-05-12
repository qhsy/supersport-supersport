package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容预约
 * 
 */
@Entity
public class CnContentMake extends BaseEntity {

	@ZooData(name = "编号")
	private String code;

	@ZooData(name = "内容编号")
	private String contentCode;

	@ZooData(name = "预约人编号")
	private String userCode;

	@ZooData(name = "预约状态")
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
