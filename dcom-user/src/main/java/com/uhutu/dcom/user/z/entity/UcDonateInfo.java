package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 粉丝捐赠能量汇总信息
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames={"supportCode","beSupportCode"}))
public class UcDonateInfo extends BaseEntity {

	@ZooData(name = "粉丝昵称", require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String supportCode;

	@ZooData(name = "达人姓名", sort = { DefineWebPage.Page_Add + "=0" })
	private String beSupportCode;

	@ZooData(name = "捐赠能量总值", require = "1")
	private long totalPower;

	public String getSupportCode() {
		return supportCode;
	}

	public void setSupportCode(String supportCode) {
		this.supportCode = supportCode;
	}

	public String getBeSupportCode() {
		return beSupportCode;
	}

	public void setBeSupportCode(String beSupportCode) {
		this.beSupportCode = beSupportCode;
	}

	public long getTotalPower() {
		return totalPower;
	}

	public void setTotalPower(long totalPower) {
		this.totalPower = totalPower;
	}

}
