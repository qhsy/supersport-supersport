package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问答信息
 * @author 逄小帅
 *
 */
public class QuestionInfo extends UserBasicInfo {
	
	@ApiModelProperty(value="问题编号")
	private String code;
	
	@ApiModelProperty(value="内容")
	private String content;
	
	@ApiModelProperty(value="分享范围")
	private String scope;
	
	@ApiModelProperty(value="提问金额")
	private String money;
	
	@ApiModelProperty(value="问题与状态")
	private String status;
	
	@ApiModelProperty(value="问题时间")
	private String questionTime;
	
	@ApiModelProperty(value="偷听人数")
	private long listen;
	
	@ApiModelProperty(value="问题提出者分成")
	private BigDecimal answerAmount;

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

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestionTime() {
		return questionTime;
	}

	public void setQuestionTime(String questionTime) {
		this.questionTime = questionTime;
	}

	public long getListen() {
		return listen;
	}

	public void setListen(long listen) {
		this.listen = listen;
	}

	public BigDecimal getAnswerAmount() {
		return answerAmount;
	}

	public void setAnswerAmount(BigDecimal answerAmount) {
		this.answerAmount = answerAmount;
	}
	

}
