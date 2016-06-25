package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 腾讯云服务交互日志实体
 * 
 * @author Administrator
 *
 */

@Entity
@Table(indexes = { @Index(columnList = "code") })
public class UcTecentLog extends BaseEntity {

	@ZooData(value = "日志编号")
	@Column(length = 50)
	private String code;

	@ZooData(value = "目标接口")
	@Column(length = 200)
	private String rsyncTarget;

	@ZooData(value = "请求url")
	@Column(length = 500)
	private String rsyncUrl;

	@ZooData(value = "请求数据")
	@Column(length = 500)
	private String requestData;

	@ZooData(value = "请求时间")
	@Column(length = 30)
	private String requestTime;

	@ZooData(value = "响应数据")
	@Column(length = 500)
	private String responseData;

	@ZooData(value = "响应时间")
	@Column(length = 30)
	private String responseTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRsyncTarget() {
		return rsyncTarget;
	}

	public void setRsyncTarget(String rsyncTarget) {
		this.rsyncTarget = rsyncTarget;
	}

	public String getRsyncUrl() {
		return rsyncUrl;
	}

	public void setRsyncUrl(String rsyncUrl) {
		this.rsyncUrl = rsyncUrl;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(String responseTime) {
		this.responseTime = responseTime;
	}

}
