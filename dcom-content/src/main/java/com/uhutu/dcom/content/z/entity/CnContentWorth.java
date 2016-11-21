package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 值得看
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentWorth extends BaseEntity {

	@ZooData(name = "内容分类", inc = {
			DefineWebInc.Web_Component + "=dzcw410710010016" }, element = DefineWebElement.Model)
	private String type;

	@ZooData(name = "内容", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010010" })
	private String contentCode;

	@ZooData(name = "展示顺序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	@ZooData(name = "标志", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=dzsd410710011010" })
	private String mark;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
