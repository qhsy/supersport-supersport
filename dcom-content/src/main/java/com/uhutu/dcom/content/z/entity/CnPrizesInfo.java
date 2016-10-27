package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 抽奖奖品
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class CnPrizesInfo extends BaseEntity {

	@ZooData(name = "奖品编号", inc = DefineWebInc.Insert_Code + "=JPBH", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	private String code;

	@ZooData(name = "奖品名称", require = "1", verify = { DefineWebVerify.Max_Length + "=28" })
	private String name;

	@ZooData(name = "奖品简介", element = DefineWebElement.Textarea, sort = { DefineWebPage.Page_Query + "=0" })
	private String aboutDesc;

	@ZooData(name = "奖品类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd410710011009" })
	private String type;

	@ZooData(name = "是否已抽", element = DefineWebElement.Select, inc = { DefineWebInc.System_Define + "=10" }, sort = {
			DefineWebPage.Page_Edit + "=0", DefineWebPage.Page_Add + "=0" })
	private int status;

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

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}