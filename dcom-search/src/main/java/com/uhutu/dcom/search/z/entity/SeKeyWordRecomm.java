package com.uhutu.dcom.search.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 推荐搜索关键字
 * 
 * @author xiegj
 *
 */
@Entity
public class SeKeyWordRecomm extends BaseEntity {

	@ZooData(name = "编号", inc = DefineWebInc.Insert_Code + "=SKWBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(name = "搜索内容", require = "1", verify = { DefineWebVerify.Max_Length + "=20" })
	@Column(length = 50)
	private String title;

	@ZooData(name = "展示排序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int sort;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
