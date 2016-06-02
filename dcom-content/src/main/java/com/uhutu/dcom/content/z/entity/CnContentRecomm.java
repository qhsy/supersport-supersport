package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容推荐信息
 * 
 * @author 逄小帅
 *
 */
@Entity
public class CnContentRecomm extends BaseEntity {

	@ZooData(name = "内容", element = DefineWebElement.Model, inc = { DefineWebInc.Web_Component + "=dzcw410710010002" })
	private String contentCode;

	@ZooData(name = "推荐理由", sort = { DefineWebPage.Page_Query + "=0" }, element = DefineWebElement.Textarea)
	private String content;

	@ZooData(name = "推荐标题", verify = { DefineWebVerify.Max_Length + "=28" })
	private String title;

	@ZooData(name = "推荐封面(1080*810)", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Grid + "=0" })
	private String cover;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

}
