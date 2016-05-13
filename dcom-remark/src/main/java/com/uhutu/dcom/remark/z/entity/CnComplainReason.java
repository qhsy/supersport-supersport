package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 投诉原因
 * @author 逄小帅
 *
 */
@Entity
public class CnComplainReason extends BaseEntity {
	
	@ZooData(name="编号")
	private String code;
	
	@ZooData(name="投诉原因内容")
	private String reason;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

}
