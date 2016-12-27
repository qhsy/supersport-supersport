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
 * 赛事直播信息
 * @author 逄小帅
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "matchCode") })
public class CnMatchLive extends BaseEntity {
	
	@ZooData(name = "赛事编号", sort = {DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process})
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "直播时间", sort = {DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Datehms, require = "1")
	@Column(length=30)
	private String startTime;
	
	@ZooData(name = "直播内容", require = "1", sort = {
			DefineWebPage.Page_Query + "=0" })
	private String content;
	
	@ZooData(name = "关联直播",element = DefineWebElement.Model, sort ={DefineWebPage.Page_Query + "=0"}, inc = {DefineWebInc.Web_Component + "=dzcw410710010002" })
	@Column(length=50)
	private String liveCode;
	
	@ZooData(name = "直播状态",sort = {DefineWebPage.Page_Query + "=0" },element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011014" })
	@Column(length=50)
	private String status;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLiveCode() {
		return liveCode;
	}

	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}
	

}
