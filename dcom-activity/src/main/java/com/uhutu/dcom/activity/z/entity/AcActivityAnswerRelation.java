package com.uhutu.dcom.activity.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 活动关联信息
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "activityCode" }), indexes = {
		@Index(columnList = "activityCode") })
public class AcActivityAnswerRelation extends BaseEntity {

	@ZooData(name = "活动编号")
	@Column(length = 50)
	private String activityCode;

	@ZooData(name = "问答编号")
	@Column(length = 50)
	private String answerCode;

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

}
