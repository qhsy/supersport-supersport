package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 赛事报名信息
 * @author 逄小帅
 *
 */
//@Entity
@Table(indexes = { @Index(columnList = "matchCode") })
public class CnMatchSign extends BaseEntity {
	
	@ZooData(name = "赛事编号",inc = DefineWebInc.Url_Param + "=matchCode",sort = {DefineWebPage.Page_Query + "=0",DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process })
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "报名编号",sort = {DefineWebPage.Page_Query + "=0",DefineWebPage.Page_Edit+"=0",DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process })
	@Column(length=50)
	private String signCode;
	
	@ZooData(name = "报名项目",element = DefineWebElement.Model,inc = {DefineWebInc.Web_Component + "=dzcw410710010021" },require = "1",sort = {DefineWebPage.Page_Query + "=0" })
	@Column(length=50)
	private String signName;
	
	@ZooData(name = "报名链接",sort = {DefineWebPage.Page_Query + "=0" })
	private String signUrl;
	
	@ZooData(name = "位置",require = "1",sort = {DefineWebPage.Page_Query + "=0" })
	private int sort;
	
	@ZooData(name = "状态",require = "1",sort = {DefineWebPage.Page_Query + "=0" },element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011013" })
	@Column(length=50)
	private String status;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getSignCode() {
		return signCode;
	}

	public void setSignCode(String signCode) {
		this.signCode = signCode;
	}

	public String getSignUrl() {
		return signUrl;
	}

	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
