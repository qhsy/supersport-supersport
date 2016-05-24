package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 运动类型数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class SpSportCategory extends BaseEntity {

	@ZooData(name = "运动编号", inc = DefineWebInc.Insert_Code + "=YDBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "运动名称", require = "1")
	private String name;

	@ZooData(name = "排序(倒序)", require = "1", sort = { DefineWebPage.Page_Query + "=0" })
	private int sort;

	@ZooData(name = "运动图标", require = "1", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String icon;

	@ZooData(name = "运动描述", element = DefineWebElement.Textarea)
	private String description;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
