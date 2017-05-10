package com.uhutu.dcom.order.z.entity;

import java.math.BigDecimal;

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
 * 订单基本信息
 * 
 * @author xiegj
 *
 */
//@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
public class OcOrderInfo extends BaseEntity {

	@ZooData(name = "订单编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "订单类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd411210011001" })
	@Column(length = 50)
	private String orderType;

	@ZooData(name = "订单来源", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" }, element = DefineWebElement.Select, inc = {
					DefineWebInc.System_Define + "=dzsd411210011002" })
	@Column(length = 50)
	private String orderSource;

	@ZooData(name = "订单状态", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd411210011003" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(length = 30)
	private String status;

	@ZooData(name = "订单金额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal orderMoney;

	@ZooData(name = "支付类型", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" }, element = DefineWebElement.Select, inc = {
					DefineWebInc.System_Define + "=dzsd411210011004" })
	@Column(length = 50)
	private String payType;

	@ZooData(name = "已支付金额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal payedMoney;

	@ZooData(name = "卖家昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String sellerCode;

	@ZooData(name = "买家昵称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Add + "=0",
					DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String buyerCode;

	@ZooData(name = "app版本", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 50)
	private String appVersion;

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

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getSellerCode() {
		return sellerCode;
	}

	public void setSellerCode(String sellerCode) {
		this.sellerCode = sellerCode;
	}

	public String getBuyerCode() {
		return buyerCode;
	}

	public void setBuyerCode(String buyerCode) {
		this.buyerCode = buyerCode;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public BigDecimal getOrderMoney() {
		return orderMoney;
	}

	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}

	public BigDecimal getPayedMoney() {
		return payedMoney;
	}

	public void setPayedMoney(BigDecimal payedMoney) {
		this.payedMoney = payedMoney;
	}

}
