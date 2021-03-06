package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 直播特效关联关系
 * 
 * @author admin
 *
 */
@Entity
public class CnLiveSpecialEffectRel extends BaseEntity {

	@ZooData(name = "直播名称", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=code")
	@Column(length = 50)
	private String code;

	@ZooData(name = "特效名称", require = "1", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw410710010025" })
	private String gameCode;

	@ZooData(name = "赠送次数", require = "1", verify = { DefineWebVerify.Base_Number })
	private int num;

	@ZooData(name = "展示顺序(倒序)", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGameCode() {
		return gameCode;
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
