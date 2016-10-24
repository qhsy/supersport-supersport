package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容商品关联信息
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentProductRel extends BaseEntity {

	@ZooData(name = "内容编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=contentCode")
	@Column(length = 50)
	private String contentCode;

	@ZooData(name = "商品信息", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010015" })
	@Column(length = 50)
	private String productCode;

	@ZooData(name = "排序", require = "1")
	private int sort;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
