package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModel;

@Entity
@ApiModel
public class CnContentType extends BaseEntity {

	@ZooData(name = "分类编号", inc = DefineWebInc.Insert_Code + "=LEXUSBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "分类名称", require = "1", verify = { DefineWebVerify.Max_Length + "=20" })
	private String name;

	@ZooData(name = "顺序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	@ZooData(name = "状态(是否可用)", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	private String status;

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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
