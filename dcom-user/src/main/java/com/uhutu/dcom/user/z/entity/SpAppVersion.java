package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * app版本信息
 * @author 逄小帅
 *
 */
@Entity
public class SpAppVersion extends BaseEntity {
	
	@ZooData(value="版本号")
	private String versionNo;
	
	@ZooData(value="升级内容")
	private String upgradeContent;
	
	@ZooData(value="升级类型")
	private String upgradeType;
	
	@ZooData(value="app升级地址")
	private String appUrl;
	
	@ZooData(value="系统类型")
	private String systemType;

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getUpgradeContent() {
		return upgradeContent;
	}

	public void setUpgradeContent(String upgradeContent) {
		this.upgradeContent = upgradeContent;
	}

	public String getUpgradeType() {
		return upgradeType;
	}

	public void setUpgradeType(String upgradeType) {
		this.upgradeType = upgradeType;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public void setAppUrl(String appUrl) {
		this.appUrl = appUrl;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

}
