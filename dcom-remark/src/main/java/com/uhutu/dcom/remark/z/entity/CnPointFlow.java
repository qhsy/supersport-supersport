package com.uhutu.dcom.remark.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 积分流水
 * 
 */
@Entity
public class CnPointFlow extends BaseEntity {

	@ZooData(name = "编号")
	private String code;

	@ZooData(name = "内容编号")
	private String contentCode;

	@ZooData(name = "用户编号")
	private String userCode;

	@ZooData(name = "积分类型")
	private String type;

	@ZooData(name = "积分数量")
	private int num;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
