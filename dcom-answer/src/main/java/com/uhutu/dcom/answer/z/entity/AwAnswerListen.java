package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 
 * @author 逄小帅
 *
 */
//@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode", "questionCode"}))
public class AwAnswerListen extends BaseEntity {
	
	@ZooData(name="用户编号")
	@Column(length=50)
	private String userCode;
	
	@ZooData(name="问题编号")
	@Column(length=50)
	private String questionCode;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getQuestionCode() {
		return questionCode;
	}

	public void setQuestionCode(String questionCode) {
		this.questionCode = questionCode;
	}

}
