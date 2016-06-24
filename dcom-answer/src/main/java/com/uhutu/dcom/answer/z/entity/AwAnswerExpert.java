package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问答达人用户信息
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "userCode" }))
public class AwAnswerExpert extends BaseEntity {
	
	@ZooData(name="用户编号")
	@Column(length=50)
	private String userCode;
	
	@ZooData(name="评价得分")
	private double score;
	
	@ZooData(name="用户问答状态")
	@Column(length=50)
	private String status;
	
	@ZooData(name="人生经历")
	@Column(columnDefinition = "longtext")
	private String experience;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

}
