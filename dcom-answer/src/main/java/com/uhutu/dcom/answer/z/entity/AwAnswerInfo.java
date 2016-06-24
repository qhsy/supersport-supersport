package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 达人问答信息
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwAnswerInfo extends BaseEntity {
	
	@ZooData(name="分类编号")
	@Column(length=50)
	private String code;
	
	@ZooData(name="问答内容")
	@Column(length=255)
	private String content;
	
	@ZooData(name="用户编号")
	@Column(length=50)
	private String userCode;
	
	@ZooData(name="服务状态")
	@Column(length=50)
	private String status;
	
	@ZooData(name="问答类型编号")
	@Column(length=50)
	private String type;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
