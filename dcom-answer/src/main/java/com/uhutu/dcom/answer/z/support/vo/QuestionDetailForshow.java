package com.uhutu.dcom.answer.z.support.vo;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

/**
 * 问题详情信息
 * 
 * @author xiegj
 *
 */
public class QuestionDetailForshow {

	@ApiModelProperty(value = "问题编号")
	private String code;

	@ApiModelProperty(value = "问题内容")
	private String content;

	@ApiModelProperty(value = "提问人编号")
	private String questionUserCode;

	@ApiModelProperty(value = "提问人类型")
	private String questionUserType;

	@ApiModelProperty(value = "提问人昵称")
	private String questionUserNickName;

	@ApiModelProperty(value = "提问人头像")
	private String questionUserHeadUrl;

	@ApiModelProperty(value = "回答人编号")
	private String answerUserCode;

	@ApiModelProperty(value = "回答人类型")
	private String answerUserType;

	@ApiModelProperty(value = "回答人昵称")
	private String answerUserNickName;

	@ApiModelProperty(value = "回答人头像")
	private String answerUserHeadUrl;

	@ApiModelProperty(value = "回答人头衔")
	private String answerUserTitle;

	@ApiModelProperty(value = "回答人粉丝数")
	private int answerUserFans;

	@ApiModelProperty(value = "提问金额(RMB)")
	private BigDecimal money;

	@ApiModelProperty(value = "偷听金额(RMB)")
	private BigDecimal sellMoney;

	@ApiModelProperty(value = "状态", notes = "dzsd4888100110010001:待回答,dzsd4888100110010002:已回答,dzsd4888100110010003:已拒绝回答,dzsd4888100110010004:到期未答,dzsd4888100110010005:已撤回")
	private String status;

	@ApiModelProperty(value = "语音路径")
	private String videoUrl;

	@ApiModelProperty(value = "语音长度(秒)")
	private int videoLengh;

	@ApiModelProperty(value = "语音文字展示")
	private String videoShow;

	@ApiModelProperty(value = "时间展示")
	private String timeShow;

	@ApiModelProperty(value = "已收听数")
	private long listen;

	@ApiModelProperty(value = "已赞数量")
	private long love;

	@ApiModelProperty(value = "是否已赞")
	private boolean loveFlag = false;

	@ApiModelProperty(value = "是否可直接听")
	private boolean listenFlag = false;

	@ApiModelProperty(value = "分享范围", notes = "dzsd4888100110020001:私密,dzsd4888100110020002:公开")
	private String scope;

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

	public String getQuestionUserNickName() {
		return questionUserNickName;
	}

	public void setQuestionUserNickName(String questionUserNickName) {
		this.questionUserNickName = questionUserNickName;
	}

	public String getQuestionUserHeadUrl() {
		return questionUserHeadUrl;
	}

	public void setQuestionUserHeadUrl(String questionUserHeadUrl) {
		this.questionUserHeadUrl = questionUserHeadUrl;
	}

	public String getAnswerUserCode() {
		return answerUserCode;
	}

	public void setAnswerUserCode(String answerUserCode) {
		this.answerUserCode = answerUserCode;
	}

	public String getAnswerUserNickName() {
		return answerUserNickName;
	}

	public void setAnswerUserNickName(String answerUserNickName) {
		this.answerUserNickName = answerUserNickName;
	}

	public String getAnswerUserHeadUrl() {
		return answerUserHeadUrl;
	}

	public void setAnswerUserHeadUrl(String answerUserHeadUrl) {
		this.answerUserHeadUrl = answerUserHeadUrl;
	}

	public String getAnswerUserTitle() {
		return answerUserTitle;
	}

	public void setAnswerUserTitle(String answerUserTitle) {
		this.answerUserTitle = answerUserTitle;
	}

	public int getAnswerUserFans() {
		return answerUserFans;
	}

	public void setAnswerUserFans(int answerUserFans) {
		this.answerUserFans = answerUserFans;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public BigDecimal getSellMoney() {
		return sellMoney;
	}

	public void setSellMoney(BigDecimal sellMoney) {
		this.sellMoney = sellMoney;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getVideoLengh() {
		return videoLengh;
	}

	public void setVideoLengh(int videoLengh) {
		this.videoLengh = videoLengh;
	}

	public String getVideoShow() {
		return videoShow;
	}

	public void setVideoShow(String videoShow) {
		this.videoShow = videoShow;
	}

	public String getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(String timeShow) {
		this.timeShow = timeShow;
	}

	public long getListen() {
		return listen;
	}

	public void setListen(long listen) {
		this.listen = listen;
	}

	public long getLove() {
		return love;
	}

	public void setLove(long love) {
		this.love = love;
	}

	public boolean isLoveFlag() {
		return loveFlag;
	}

	public void setLoveFlag(boolean loveFlag) {
		this.loveFlag = loveFlag;
	}

	public boolean isListenFlag() {
		return listenFlag;
	}

	public void setListenFlag(boolean listenFlag) {
		this.listenFlag = listenFlag;
	}

	public String getQuestionUserType() {
		return questionUserType;
	}

	public void setQuestionUserType(String questionUserType) {
		this.questionUserType = questionUserType;
	}

	public String getAnswerUserType() {
		return answerUserType;
	}

	public void setAnswerUserType(String answerUserType) {
		this.answerUserType = answerUserType;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}
