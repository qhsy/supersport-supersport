package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 投诉
 * @author 逄小帅
 *
 */

@Entity
public class CnSupportComplain extends BaseEntity {
	
	@ZooData(name="编号")
	private String code;
	
	@ZooData(name="内容编号")
	private String contentCode;
	
	@ZooData(name="投诉原因编号")
	private String reasonCode;
	
	@ZooData(name="备注信息")
	private String remark;
	
	@ZooData(name="类型")
	private String type;

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

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
