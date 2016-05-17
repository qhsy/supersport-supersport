package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容推荐信息
 * 
 * @author 逄小帅
 *
 */
@Entity
public class CnContentRecomm extends BaseEntity {

	@ZooData(name = "内容编号")
	private String contentCode;

	@ZooData(name = "内容信息", sort = { DefineWebPage.Page_Query + "=0" })
	private String content;

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

}
