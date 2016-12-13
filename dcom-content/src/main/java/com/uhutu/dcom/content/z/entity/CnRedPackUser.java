package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 人员打赏金额信息
 * 
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode", "busiCode" }))
public class CnRedPackUser extends BaseEntity {

	@ZooData(value = "业务编号")
	@Column(length = 50)
	private String busiCode;

	@ZooData(value = "接受打赏者昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length = 50)
	private String userCode;

	@ZooData(value = "打赏金额")
	private BigDecimal money;

	@ZooData(value = "分成比例1~100", verify = { DefineWebVerify.Base_Number, DefineWebVerify.Max_Length + "=1",
			DefineWebVerify.Min_Length + "=100" })
	private BigDecimal scale;

	@ZooData(value = "排序", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private int sort;

	@ZooData(value = "分成状态", sort = { DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=10" })
	@Column(length = 50)
	private String status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
