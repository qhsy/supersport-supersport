package com.uhutu.dcom.user.z.entity;

import java.util.Date;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 粉丝能量信息
 * 
 * @author xiegj
 *
 */
@Entity
public class UcUserinfoDonate extends BaseEntity {

	@ZooData(name = "用户昵称", require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw451010010001" })
	private String userCode;

	@ZooData(name = "最新能量值", require = "1", verify = DefineWebVerify.Base_Phone)
	private long currPower;

	@ZooData(name = "可用能量值", require = "1", verify = DefineWebVerify.Base_Phone)
	private long freePower;

	@ZooData(name = "当前日期", require = "1", sort = { DefineWebPage.Page_Query + "=0" })
	private Date expire;

	@ZooData(name = "设备唯一编号", require = "1", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String deviceId;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public long getCurrPower() {
		return currPower;
	}

	public void setCurrPower(long currPower) {
		this.currPower = currPower;
	}

	public long getFreePower() {
		return freePower;
	}

	public void setFreePower(long freePower) {
		this.freePower = freePower;
	}

	public Date getExpire() {
		return expire;
	}

	public void setExpire(Date expire) {
		this.expire = expire;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
