package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 栏目与内容数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentItemRel extends BaseEntity {

	@ZooData(name = "栏目名称", element = "select", inc = { "source_code=dzsi41071002", "source_value='222222'" })
	private String itemCode;

	@ZooData(name = "内容名称", element = "select", sort = { "pq=0" }, inc = { "source_code=dzsi41071003",
			"source_value='333333'" })
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
