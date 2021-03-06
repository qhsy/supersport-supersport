package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.dcom.answer.z.common.AnswerEnum;
import com.uhutu.dcom.component.z.util.CalendarUtil;
import com.uhutu.zoocom.helper.DateHelper;

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
	private BigDecimal money;
	
	@ApiModelProperty(value="问题与状态")
	private String status;
	
	@ApiModelProperty(value="问题时间")
	private String questionTime;
	
	@ApiModelProperty(value="问题时间展示")
	private String questionTimeStr;
	
	@ApiModelProperty(value="偷听人数")
	private long listen;
	
	@ApiModelProperty(value="语音长度")
	private int lengh;
	
	@ApiModelProperty(value="问题回答者分成")
	private BigDecimal answerAmount;
	
	@ApiModelProperty(value="问题提问者分成")
	private BigDecimal askAmount;
	
	@ApiModelProperty(value="语音路径")
	private String url;
	
	@ApiModelProperty(value="语音内容")
	private String soundContent;
	
	@ApiModelProperty(value="点赞数量")
	private long praiseNum;
	
	@ApiModelProperty(value="状态文本")
	private String statusText;
	
	@ApiModelProperty(value="回答人用户信息")
	private AnswerUserInfo answerUserInfo;
	
	@ApiModelProperty(value = "是否可直接听")
	private boolean listenFlag = false;
	
	@ApiModelProperty(value = "是否参加活动")
	private boolean activityFlag = false;

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

	public BigDecimal getMoney() {
		
		if(money == null){
			
			setMoney(BigDecimal.ZERO);
			
		}
		
		return money;
	}

	public void setMoney(BigDecimal money) {
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
		
		if(answerAmount == null){
			
			setAnswerAmount(BigDecimal.ZERO);
			
		}
		
		return answerAmount;
	}

	public void setAnswerAmount(BigDecimal answerAmount) {
		this.answerAmount = answerAmount;
	}

	public int getLengh() {
		return lengh;
	}

	public void setLengh(int lengh) {
		this.lengh = lengh;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSoundContent() {
		return soundContent;
	}

	public void setSoundContent(String soundContent) {
		this.soundContent = soundContent;
	}

	public long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getStatusText() {
		
		return AnswerEnum.praseText(getStatus());
		
	}

	public AnswerUserInfo getAnswerUserInfo() {
		return answerUserInfo;
	}

	public void setAnswerUserInfo(AnswerUserInfo answerUserInfo) {
		this.answerUserInfo = answerUserInfo;
	}

	public String getQuestionTimeStr() {
		
		String temp = questionTime;
		
		if(StringUtils.isNotBlank(questionTime)){
			
			Date questionDate = DateHelper.parseDate(questionTime);
			
			temp = CalendarUtil.formateTip(questionDate);
			
		}
		
		return temp;
		
	}

	public boolean isListenFlag() {
		return listenFlag;
	}

	public void setListenFlag(boolean listenFlag) {
		this.listenFlag = listenFlag;
	}

	public void setQuestionTimeStr(String questionTimeStr) {
		this.questionTimeStr = questionTimeStr;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}

	public BigDecimal getAskAmount() {
		
		if(askAmount == null){
			
			askAmount = BigDecimal.ZERO;
			
		}
		
		return askAmount;
	}

	public void setAskAmount(BigDecimal askAmount) {
		this.askAmount = askAmount;
	}

}
