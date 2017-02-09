package com.uhutu.dcom.content.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoocom.define.DefineWebVerify;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 红包信息
 * 
 * @author 逄小帅
 *
 */
@Entity
public class CnRedPackInfo extends BaseEntity {

	@ZooData(value = "编号", inc = DefineWebInc.Insert_Code + "=CRPI", sort = { DefineWebPage.Page_Add + "=1",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(name = "内容封面(宽45*高45)", element = DefineWebElement.Upload, require = "1", sort = {
			DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	private String pic;

	@ZooData(value = "金额", require = "1")
	private BigDecimal money;

	@ZooData(value = "排序", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

	@ZooData(value = "类型", require = "1",element = DefineWebElement.Select,inc = {
			DefineWebInc.System_Define + "=dzsd410710011016" })
	private String type;
	
	@ZooData(value = "状态", require = "1", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=10" })
	@Column(length = 50)
	private String status;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
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
