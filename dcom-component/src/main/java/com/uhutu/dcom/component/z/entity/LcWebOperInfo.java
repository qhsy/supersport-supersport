package com.uhutu.dcom.component.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * web页面操作日志
 * @author 逄小帅
 *
 */
@Entity
public class LcWebOperInfo extends BaseEntity {
	
	@ZooData(name="页面识别码")
	private String pageUnique;
	
	@ZooData(name="操作编码")
	private String operateCode;
	
	@ZooData(name="页面链接地址")
	private String pageUrl;
	
	@ZooData(name="用户token")
	private String userToken;
	
	@ZooData(name="操作数据")
	@Column(columnDefinition = "longtext")
	private String operData;
	
	@ZooData(name="修改之前数据")
	@Column(columnDefinition = "longtext")
	private String oldData;

	public String getPageUnique() {
		return pageUnique;
	}

	public void setPageUnique(String pageUnique) {
		this.pageUnique = pageUnique;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getUserToken() {
		return userToken;
	}

	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}

	public String getOperData() {
		return operData;
	}

	public void setOperData(String operData) {
		this.operData = operData;
	}

	public String getOldData() {
		return oldData;
	}

	public void setOldData(String oldData) {
		this.oldData = oldData;
	}

}
