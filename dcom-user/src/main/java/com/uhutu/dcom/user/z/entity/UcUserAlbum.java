package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebSort;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 达人图集信息
 * 
 * @author xiegj
 *
 */
@Entity
public class UcUserAlbum extends BaseEntity {

	@ZooData(name = "达人姓名", sort = { DefineWebPage.Page_Query + "=0",
			DefineWebPage.Page_Add + "=" + DefineWebSort.Sort_Process,
			DefineWebPage.Page_Edit + "=" + DefineWebSort.Sort_Process }, inc = DefineWebInc.Url_Param + "=userCode")
	private String userCode;

	@ZooData(name = "达人签名图片", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String picture;

	@ZooData(name = "排名(倒序)", require = "1", verify = { DefineWebVerify.Base_Number }, sort = {
			DefineWebPage.Page_Query + "=0" })
	private int sort;

	@ZooData(name = "状态是否正常", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd469910011001" })
	private String status;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
