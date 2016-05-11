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

	@ZooData(name = "栏目名称", element = "select", inc = {"system_define=dzsi46991002"})
	private String itemCode;

	@ZooData(name = "内容名称", element = "select", inc = {"system_define=dzsi46991003"})
	private String contentCode;

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

}
