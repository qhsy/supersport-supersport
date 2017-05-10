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
 * 专题内容信息
 * 
 * @author xiegj
 *
 */
//@Entity
public class CnThemeDetail extends BaseEntity {

	@ZooData(name = "专题栏目编号", inc = DefineWebInc.Insert_Code + "=ZTLMBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(name = "专题栏目标题", require = "1", verify = { DefineWebVerify.Max_Length + "=255" })
	@Column(length = 255)
	private String title;

	@ZooData(name = "栏目类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011007" }, sort = { DefineWebPage.Page_Query + "=0",
					DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Grid + "=0" })
	private String type;

	@ZooData(name = "状态 ", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" })
	@Column(length = 30)
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
