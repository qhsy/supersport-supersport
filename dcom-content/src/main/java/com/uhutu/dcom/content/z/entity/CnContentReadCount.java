package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 阅读量
 * 
 * @author xiegj
 *
 */
@Entity
public class CnContentReadCount extends BaseEntity {

	@ZooData(name = "内容编号", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010002" })
	@Column(length = 50)
	private String contentCode;

	@ZooData(name = "阅读量", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int count;

	@ZooData(name = "备注", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	@Column(length = 255)
	private String remark;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
