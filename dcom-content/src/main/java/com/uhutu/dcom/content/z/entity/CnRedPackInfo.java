package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
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

	@ZooData(value = "编号", require = "1")
	@Column(length = 50)
	private String code;

	@ZooData(value = "金额", require = "1")
	private int money;

	@ZooData(value = "排序", require = "1", verify = { DefineWebVerify.Base_Number })
	private int sort;

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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
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
