package com.uhutu.dcom.content.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 点赞数据模型
 * 
 * @author xiegj
 *
 */
@Entity
public class CnSupportPraise extends BaseEntity{

	@ZooData(name = "评价编号")
	private String code;
	
	@ZooData(name = "内容编号")
	private String contentCode;

	@ZooData(name = "评价类型")
	private String type;
	
	@ZooData(name = "用户编号")
	private String userCode;
	
	@ZooData(name="状态")
	private String status;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
