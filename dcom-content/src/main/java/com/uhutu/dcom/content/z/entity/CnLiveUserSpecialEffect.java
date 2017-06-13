package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户特效信息表
 * 
 * @author xiegj
 *
 */
@Entity
public class CnLiveUserSpecialEffect extends BaseEntity {

	@ZooData(name = "用户编号", require = "1", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String userCode;

	@ZooData(name = "特效编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String seCode;

	@ZooData(name = "直播间编号&阵营编号", sort = { DefineWebPage.Page_Add + "=0", DefineWebPage.Page_Edit + "=0" })
	private String param;

	@ZooData(name = "数量", element = DefineWebElement.Input, verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Add + "=0" }, require = "1")
	private long num = 0;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getSeCode() {
		return seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
