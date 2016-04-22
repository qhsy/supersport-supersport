package com.uhutu.dcom.content.entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 
 * 广告基本信息
 * 
 * @author xiegj
 *
 */
public class CnAdvertiseInfo extends BaseEntity {

	@ZooData(name = "广告编号")
	private String code;

	@ZooData(name = "广告类型")
	private String type;

	@ZooData(name = "广告状态")
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
