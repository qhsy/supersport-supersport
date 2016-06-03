package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 图集信息
 * 
 * @author pang_jhui
 *
 */
@Entity
public class CnContentPhotos extends BaseEntity {

	@ZooData(name = "内容标题", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=contentCode")
	private String contentCode;

	@ZooData(name = "图片(宽：1080)", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0" }, inc = { DefineWebInc.Client_Extend + "=500" })
	private String picture;

	@ZooData(name = "图片简述", element = DefineWebElement.Textarea)
	private String content;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
