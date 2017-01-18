package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 赛事相关跳转
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "matchCode" }))
public class CnMatchLink extends BaseEntity {
	
	@ZooData(name = "赛事编号",  inc = DefineWebInc.Url_Param + "=matchCode",sort = {DefineWebPage.Page_Query + "=1",DefineWebPage.Page_Edit+"="+DefineWebSort.Sort_Process, DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process})
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "标题", require = "1",verify = { DefineWebVerify.Max_Length + "=20" },sort = {DefineWebPage.Page_Query + "=1"})
	@Column(length=50)
	private String title;
	
	@ZooData(name = "跳转类型", require = "1",element = DefineWebElement.Select,inc = {DefineWebInc.System_Define + "=dzsd410710011015" },sort = {DefineWebPage.Page_Query + "=1"})
	@Column(length=50)
	private String linkType;
	
	@ZooData(name = "跳转内容", require = "1",sort = {DefineWebPage.Page_Query + "=1"})
	private String linkContent;
	
	@ZooData(name = "跳转后的标题",sort = {DefineWebPage.Page_Query + "=1"})
	private String linkTitle;
	
	@ZooData(name = "状态",element = DefineWebElement.Select,inc = {DefineWebInc.System_Define + "=dzsd410710011013" },sort = {DefineWebPage.Page_Query + "=1"})
	private String status;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkContent() {
		return linkContent;
	}

	public void setLinkContent(String linkContent) {
		this.linkContent = linkContent;
	}

	public String getLinkTitle() {
		return linkTitle;
	}

	public void setLinkTitle(String linkTitle) {
		this.linkTitle = linkTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
