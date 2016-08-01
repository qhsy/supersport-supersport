package com.uhutu.dcom.user.z.page.vo;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 用户关注信息
 * 
 * @author xiegj
 *
 */
public class UcAttentionInfo extends BaseEntity {

	@ZooData(name = "粉丝", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010004" })
	private String attention;

	@ZooData(name = "被关注者", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=userCode")
	private String beAttention;

	@ZooData(name = "是否状态", comment = "0:未关注 1:已关注", element = DefineWebElement.Select, sort = {
			DefineWebPage.Page_Add + "=0" }, inc = { DefineWebInc.System_Define + "=10" })
	private String status;

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getBeAttention() {
		return beAttention;
	}

	public void setBeAttention(String beAttention) {
		this.beAttention = beAttention;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
