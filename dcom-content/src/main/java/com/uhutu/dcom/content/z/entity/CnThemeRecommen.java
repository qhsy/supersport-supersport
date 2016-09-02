package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 专题推荐达人信息
 * 
 * @author xiegj
 *
 */
@Entity
public class CnThemeRecommen extends BaseEntity {

	@ZooData(name = "分享的内容编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=code")
	@Column(length = 50)
	private String code;

	@ZooData(name = "达人", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010003" })
	@Column(length = 50)
	private String userCode;

	@ZooData(name = "展示排序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int sort;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
