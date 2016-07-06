package com.uhutu.dcom.answer.z.support.vo;

import com.uhutu.zoocom.root.RootClass;

import io.swagger.annotations.ApiModelProperty;

public class QuestionForShow extends RootClass {

	@ApiModelProperty(name = "问题编号")
	private String code;

	@ApiModelProperty(name = "问题详情")
	private String content;

	@ApiModelProperty(name = "语音展示文字")
	private String soundContent;

	@ApiModelProperty(name = "语音长度")
	private int length;

	@ApiModelProperty(name = "回答者编号")
	private String userCode;

	@ApiModelProperty(name = "回答者昵称")
	private String nickName;

	@ApiModelProperty(name = "回答者头像")
	private String headUrl;

	@ApiModelProperty(name = "回答者头衔")
	private String title;

	@ApiModelProperty(name = "已收听数")
	private long listen;

	@ApiModelProperty(name = "时间展示")
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

}
