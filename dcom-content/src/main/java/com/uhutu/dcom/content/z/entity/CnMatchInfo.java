package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 赛事信息
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class CnMatchInfo extends BaseEntity {
	
	@ZooData(name = "赛事编号", inc = DefineWebInc.Insert_Code + "=MH",sort={DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length=50)
	private String code;
	
	@ZooData(name = "赛事名称",require = "1")
	private String name;
	
	@ZooData(name = "赛事封面图", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String cover;
	
	@ZooData(name = "赛事举办者", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" })
	@Column(length=50)
	private String userCode;
	
	@ZooData(name = "开始时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length=30)
	private String startTime;
	
	@ZooData(name = "结束时间", element = DefineWebElement.Datehms, require = "1")
	@Column(length=30)
	private String endTime;	
	
	@ZooData(name = "地点",require = "1")
	private String place;
	
	@ZooData(name = "标签", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011012" })
	private String flag;
	
	@ZooData(name="排序", require="1",sort = {DefineWebPage.Page_Query + "=0"})
	private int sort;
	
	@ZooData(name = "状态", require = "1",sort = {DefineWebPage.Page_Query + "=0"}, element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011013" })
	private String status;
	
	@ZooData(name="赛事详情",element = DefineWebElement.Upload,sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" },inc = {
			DefineWebInc.Client_Extend + "=5" })
	@Column(columnDefinition = "longtext")
	private String content;

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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	

}
