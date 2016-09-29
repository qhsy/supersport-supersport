package com.uhutu.dcom.user.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问答个人信息设置
 * 
 * @author xiegj
 *
 */
@Entity
public class UcDialogInfo extends BaseEntity {

	@ZooData(name = "用户编号", require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Model, inc = {
					DefineWebInc.Web_Component + "=dzcw451010010002" })
	@Column(length = 50, unique = true)
	private String code;

	@ZooData(name = "头衔", require = "1")
	@Column(length = 100)
	private String signPic;

	@ZooData(name = "简介", require = "1", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String desc;

	@ZooData(name = "问答服务金额")
	private int money;

	@ZooData(name = "总收入")
	private int dueMoney;

	@ZooData(name = "总收入")
	private int totalMoney;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSignPic() {
		return signPic;
	}

	public void setSignPic(String signPic) {
		this.signPic = signPic;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDueMoney() {
		return dueMoney;
	}

	public void setDueMoney(int dueMoney) {
		this.dueMoney = dueMoney;
	}

	public int getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
	}

}
