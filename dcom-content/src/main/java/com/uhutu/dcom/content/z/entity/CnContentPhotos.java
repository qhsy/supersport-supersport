package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 图集信息
 * 
 * @author pang_jhui
 *
 */
@Entity
public class CnContentPhotos extends BaseEntity {

	@ZooData(name = "内容名称", sort = { DefineWebPage.Page_Edit + "=0" }, element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010006" })
	private String contentCode;

	@ZooData(name = "图片路径", element = DefineWebElement.Upload, sort = { DefineWebPage.Page_Query + "=0" })
	private String picture;

	@ZooData(name = "内容信息", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
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
