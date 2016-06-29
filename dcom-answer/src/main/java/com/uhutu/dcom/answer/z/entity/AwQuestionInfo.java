package com.uhutu.dcom.answer.z.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 问题信息
 * 
 * @author 逄小帅
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwQuestionInfo extends BaseEntity {

	@ZooData(name = "问题编号")
	@Column(length = 50)
	private String code;

	@ZooData(name = "问题内容")
	@Column(length = 255)
	private String content;

	@ZooData(name = "提问人用户编号")
	@Column(length = 50)
	private String questionUserCode;

	@ZooData(name = "回答人用户编号")
	@Column(length = 50)
	private String answerUserCode;

	@ZooData(name = "提问金额")
	private int money;

	@ZooData(name = "偷听金额")
	private int sellMoney;

	@ZooData(name = "状态", demo = "dzsd4888100110010001:待回答,dzsd4888100110010002:已回答,dzsd4888100110010003:已拒绝回答")
	@Column(length = 50)
	private String status;

	@ZooData(name = "分享范围", demo = "dzsd4888100110020001:私密,dzsd4888100110020002:公开")
	@Column(length = 50)
	private String scope;

	@ZooData(name = "语音路径")
	@Column(length = 500)
	private String url;

	@ZooData(name = "提问时间")
	@Column(length = 50)
	private String questionTime;

	@ZooData(name = "回答时间")
	@Column(length = 50)
	private String answerTime;

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

	public String getQuestionUserCode() {
		return questionUserCode;
	}

	public void setQuestionUserCode(String questionUserCode) {
		this.questionUserCode = questionUserCode;
	}

	public String getAnswerUserCode() {
		return answerUserCode;
	}

	public void setAnswerUserCode(String answerUserCode) {
		this.answerUserCode = answerUserCode;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getSellMoney() {
		return sellMoney;
	}

	public void setSellMoney(int sellMoney) {
		this.sellMoney = sellMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuestionTime() {
		return questionTime;
	}

	public void setQuestionTime(String questionTime) {
		this.questionTime = questionTime;
	}

	public String getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}

}