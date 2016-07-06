package com.uhutu.dcom.pay.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 支付信息
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "orderCode" }))
public class PaPayInfo extends BaseEntity {
	
	@ZooData(name="订单编号")
	@Column(length=50)
	private String orderCode;
	
	@ZooData(name="外部系统编号")
	@Column(length=50)
	private String outCode;
	
	@ZooData(name="支付类型")
	@Column(length=50)
	private String payType;

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getOutCode() {
		return outCode;
	}

	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}

}
