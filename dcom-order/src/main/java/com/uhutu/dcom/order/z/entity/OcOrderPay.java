package com.uhutu.dcom.order.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 订单支付信息
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
public class OcOrderPay extends BaseEntity {

	@ZooData(name = "订单编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "支付流水号")
	@Column(length = 100)
	private String orderType;

	@ZooData(name = "支付类型", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" }, element = DefineWebElement.Select, inc = { DefineWebInc.System_Define
					+ "=dzsd411210011004" }, comment = "dzsd4112100110040001:支付宝，dzsd4112100110040002:微信")
	@Column(length = 50)
	private String payType;

	@ZooData(name = "已支付金额")
	private double payedMoney;

	@ZooData(name = "支付时间")
	@Column(length = 50)
	private String payTime;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public double getPayedMoney() {
		return payedMoney;
	}

	public void setPayedMoney(double payedMoney) {
		this.payedMoney = payedMoney;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

}
