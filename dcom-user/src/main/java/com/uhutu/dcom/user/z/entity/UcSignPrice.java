package com.uhutu.dcom.user.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 报名价格信息表
 * 
 * @author xiegj
 *
 */
@Entity
public class UcSignPrice extends BaseEntity {

	@ApiModelProperty(value = "参赛类型: dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准")
	@ZooData(name = "参赛类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710051002" }, require = "1")
	@Column(length = 50)
	private String type;

	@ApiModelProperty(value = "价格")
	@ZooData(name = "活动价格", require = "1")
	private BigDecimal price;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
