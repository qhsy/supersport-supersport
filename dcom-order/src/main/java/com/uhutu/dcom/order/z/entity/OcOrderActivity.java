package com.uhutu.dcom.order.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }), indexes = { @Index(columnList = "code") })
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

	@ZooData(name = "商品活动金额")
	private double productActivityPrice;

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

	public double getProductActivityPrice() {
		return productActivityPrice;
	}

	public void setProductActivityPrice(double productActivityPrice) {
		this.productActivityPrice = productActivityPrice;
	}

	
}
