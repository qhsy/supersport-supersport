package com.uhutu.dcom.answer.z.support.vo;

import org.apache.commons.lang3.StringUtils;

import com.uhutu.zoocom.root.RootClass;

import io.swagger.annotations.ApiModelProperty;

public class QuestionForShow extends RootClass {

	@ApiModelProperty(value = "问题编号")
	private String code;

	@ApiModelProperty(value = "问题详情")
	private String content;

	@ApiModelProperty(value = "语音展示文字")
	private String soundContent;

	@ApiModelProperty(value = "语音长度")
	private int length;

	@ApiModelProperty(value = "回答者编号")
	private String userCode;

	@ApiModelProperty(value = "回答者昵称")
	private String nickName;

	@ApiModelProperty(value = "回答者头像")
	private String headUrl;

	@ApiModelProperty(value = "回答者用户类型",notes="dzsd4107100310010001:普通用户，dzsd4107100310010002：体育达人")
	private String userType;
	
	@ApiModelProperty(value = "回答者头衔")
	private String title;

	@ApiModelProperty(value = "已收听数")
	private long listen;

	@ApiModelProperty(value = "是否可直接听")
	private boolean listenFlag = false;
	
	@ApiModelProperty(value = "是否参加活动")
	private boolean activityFlag = false;
	
	@ApiModelProperty(value = "时间展示")
	private String timeShow;

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

	public String getSoundContent() {
		return soundContent;
	}

	public void setSoundContent(String soundContent) {
		this.soundContent = soundContent;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
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

	public String getTitle() {
		
		if(StringUtils.isBlank(title)){
			
			title = "";
			
		}
		
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getListen() {
		return listen;
	}

	public void setListen(long listen) {
		this.listen = listen;
	}

	public String getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(String timeShow) {
		this.timeShow = timeShow;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public boolean isListenFlag() {
		return listenFlag;
	}

	public void setListenFlag(boolean listenFlag) {
		this.listenFlag = listenFlag;
	}

	public boolean isActivityFlag() {
		return activityFlag;
	}

	public void setActivityFlag(boolean activityFlag) {
		this.activityFlag = activityFlag;
	}

}
