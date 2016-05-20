package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 栏目与内容数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentItemRel extends BaseEntity {

	@ZooData(name = "栏目名称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010003" })
	private String itemCode;

	@ZooData(name = "内容名称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010002" })
	private String contentCode;

	@ZooData(name = "展示顺序(倒序)")
	private String sort;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

}
