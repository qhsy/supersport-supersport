package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 内容评论信息
 * 
 * @author 逄小帅
 *
 */
@Entity
public class CnContentRemark extends BaseEntity {

	@ZooData(name = "评论编号", sort = { DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "内容标题", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010002" }, sort = { DefineWebPage.Page_Edit + "=0" })
	private String contentCode;

	@ZooData(name = "评论内容", sort = { DefineWebPage.Page_Edit + "=0" })
	private String remark;

	@ZooData(name = "作者名称", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Edit + "=0" })
	private String author;

	@ZooData(name = "父级编号", sort = { DefineWebPage.Page_Edit + "=0" })
	private String parentCode;

	@ZooData(name = "是否通过", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
