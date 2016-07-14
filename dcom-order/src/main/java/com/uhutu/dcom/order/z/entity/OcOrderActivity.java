package com.uhutu.dcom.order.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 订单基本信息
 * 
 * @author xiegj
 *
 */
@Entity
public class OcOrderActivity extends BaseEntity {

	@ZooData(name = "订单编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "商品编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	@Column(length = 30)
	private String productCode;

	@ZooData(name = "活动编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	@Column(length = 30)
	private String activityCode;

	@ZooData(name = "商品金额")
	private BigDecimal productPrice;

	@ZooData(name = "商品活动金额")
	private BigDecimal productActivityPrice;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public BigDecimal getProductActivityPrice() {
		return productActivityPrice;
	}

	public void setProductActivityPrice(BigDecimal productActivityPrice) {
		this.productActivityPrice = productActivityPrice;
	}

}
