package com.uhutu.dcom.tag.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 推荐标签
 * 
 * @author pangjh
 *
 */
@Entity
public class CnLabelRecomm extends BaseEntity {

	@ZooData(name = "类型", element = DefineWebElement.Select, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=0",
			DefineWebPage.Page_Edit + "=0" }, inc = { DefineWebInc.System_Define + "=dzsd412410011002" })
	@Column(length = 50)
	private String type;

	@ZooData(name = "标签编号", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw412410010002" })
	@Column(length = 50)
	private String tagCode;

	@ZooData(name = "展示排序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int sort;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
