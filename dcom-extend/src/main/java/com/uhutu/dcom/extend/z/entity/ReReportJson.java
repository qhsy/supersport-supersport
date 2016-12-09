package com.uhutu.dcom.extend.z.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 报表存值
 * 
 * @author xiegj
 *
 */
@Entity
public class ReReportJson extends BaseEntity {

	@ZooData(name = "报表编号")
	private String code;

	@ZooData(name = "报名编号")
	private String signCode;

	@ZooData(name = "报表值")
	private String json;

	@ZooData(name = "创建时间")
	private String createTime;

	@ZooData(name = "状态 1:已支付，0:未支付")
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

}
