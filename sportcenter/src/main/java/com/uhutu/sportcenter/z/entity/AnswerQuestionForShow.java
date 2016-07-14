package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootClass;

import io.swagger.annotations.ApiModelProperty;

public class AnswerQuestionForShow extends RootClass {

	@ApiModelProperty(value = "用户编号")
	private String userCode;

	@ApiModelProperty(value = "用户类型")
	private String type;

	@ApiModelProperty(value = "用户昵称")
	private String nickName;

	@ApiModelProperty(value = "用户头像")
	private String headUrl;

	@ApiModelProperty(value = "提问金额")
	private BigDecimal askMoney;

	@ApiModelProperty(value = "问题编号")
	private String answerCode;

	@ApiModelProperty(value = "问题内容")
	private String content;

	@ApiModelProperty(value = "问题类型", notes = "dzsd4888100110020001私密，dzsd4888100110020002公开")
	private String scope;

	@ApiModelProperty(value = "状态  dzsd4888100110010001:待回答,dzsd4888100110010002:已回答,dzsd4888100110010003:已拒绝回答,dzsd4888100110010004:到期未答,dzsd4888100110010005:已撤回")
	private String status;
	
	@ApiModelProperty(value = "剩余时间展示", notes = "还有23小时30分过期")
	private String timeShow;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public BigDecimal getAskMoney() {
		return askMoney;
	}

	public void setAskMoney(BigDecimal askMoney) {
		this.askMoney = askMoney;
	}

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
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

	public String getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(String timeShow) {
		this.timeShow = timeShow;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
