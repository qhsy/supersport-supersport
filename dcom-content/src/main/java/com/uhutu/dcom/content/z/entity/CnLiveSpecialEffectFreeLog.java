package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 特效赠送日志
 * 
 * @author xiegj
 *
 */
@Entity
public class CnLiveSpecialEffectFreeLog extends BaseEntity {

	@ZooData(name = "特效编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String seCode;

	@ZooData(name = "赠送类型", element = DefineWebElement.Select, sort = { DefineWebPage.Page_Edit + "=0" }, inc = {
			DefineWebInc.System_Define + "=dzsd410710011021" })
	private String zsType;

	@ZooData(name = "赠送参数")
	private String param;

	@ZooData(name = "赠送数量", element = DefineWebElement.Input, verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0" }, require = "1")
	private long num = 0;

	public String getSeCode() {
		return seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

	public String getZsType() {
		return zsType;
	}

	public void setZsType(String zsType) {
		this.zsType = zsType;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

}
