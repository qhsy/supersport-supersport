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
 * 赛事相关视频
 * @author 逄小帅
 *
 */
@Entity
@Table(indexes = { @Index(columnList = "matchCode") })
public class CnMatchVideo extends BaseEntity {
	
	@ZooData(name = "内容编号",inc = DefineWebInc.Url_Param + "=matchCode",sort = {DefineWebPage.Page_Query + "=0",DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process })
	@Column(length=50)
	private String matchCode;
	
	@ZooData(name = "内容",element = DefineWebElement.Model, sort ={DefineWebPage.Page_Query + "=0"}, inc = {DefineWebInc.Web_Component + "=dzcw410710010002" })
	@Column(length=50)
	private String contentCode;
	
	@ZooData(name = "自定义封面", element = DefineWebElement.Upload, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String cover;
	
	@ZooData(name = "位置",require = "1",sort ={DefineWebPage.Page_Query + "=0"})
	private int sort;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
