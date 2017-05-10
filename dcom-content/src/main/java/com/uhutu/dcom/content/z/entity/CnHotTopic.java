package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 热门话题
 * @author 逄小帅
 *
 */
//@Entity
public class CnHotTopic extends BaseEntity {
	
	@ZooData(value="话题名称",require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw412410010001" })
	private String contentCode;
	
	@ZooData(value="话题封面(1080*420)", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;
	
	@ZooData(value="话题标题", verify = { DefineWebVerify.Max_Length + "=28" })
	private String title;
	
	@ZooData(value="排序",require = "1" ,sort = { DefineWebPage.Page_Query + "=0"})
	private int sort;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	

}
