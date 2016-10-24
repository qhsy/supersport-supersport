package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 商品信息
 * 
 * @author xiegj
 *
 */
@Entity
public class PcProductInfo extends BaseEntity {

	@ZooData(name = "商品编号", inc = DefineWebInc.Insert_Code + "=PIBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 80)
	private String code;

	@ZooData(name = "商品名称", require = "1")
	@Column(length = 255)
	private String name;

	@ZooData(name = "商品图片", element = DefineWebElement.Upload, require = "1", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String picurl;

	@ZooData(name = "商品价格", require = "1", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal price;

	@ZooData(name = "是否可售 ", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	@Column(length = 20)
	private String status;

	@ZooData(name = "商品描述", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String remark;

	@ZooData(name = "淘宝链接", require = "1", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String url;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
