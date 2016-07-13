package com.uhutu.dcom.pay.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 接口调用日志信息
 * @author 逄小帅
 *
 */
@Entity
public class PaInclogInfo extends BaseEntity {
	
	@ZooData(name="业务编号")
	@Column(length=50)
	private String busiCode;
	
	@ZooData(name="接口类型")
	@Column(length=30)
	private String incType;
	
	@ZooData(name="备注")
	@Column(columnDefinition = "longtext")
	private String remark;
	
	@ZooData(name="请求信息")
	@Column(columnDefinition = "longtext")
	private String requestData;
	
	@ZooData(name="响应信息")
	@Column(columnDefinition = "longtext")
	private String responseData;

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public String getIncType() {
		return incType;
	}

	public void setIncType(String incType) {
		this.incType = incType;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
