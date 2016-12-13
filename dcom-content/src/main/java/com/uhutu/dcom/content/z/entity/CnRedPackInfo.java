package com.uhutu.dcom.content.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 红包信息
 * @author 逄小帅
 *
 */
@Entity
public class CnRedPackInfo extends BaseEntity {

	@ZooData(value="编号")
	@Column(length = 50)
	private String code;
	
	@ZooData(value="金额")
	private int money;

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
	
}
