package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 提问输入信息
 *
 */
public class ApiForAskQuestionInput extends RootApiInput {
	@ApiModelProperty(value = "问题内容", required = true)
	private String content;

	@ApiModelProperty(value = "需要回答问题者", required = true)
	private String answerUserCode;

	@ApiModelProperty(value = "分享范围", notes = "dzsd4888100110020001:私密,dzsd4888100110020002:公开", required = true)
	private String scope;

	@ApiModelProperty(value = "来源", notes = "dzsd4112100110020001:app订单,dzsd4112100110020002:wap订单", example = "dzsd4112100110020002", required = true)
	private String orderSource;
	
	@ApiModelProperty(value="服务ip")
	private String serveIP;
	
	@ApiModelProperty(value="终端IP")
	private String romoteIP;
	
	public String getOrderSource() {
		return orderSource;
	}

	public String getServeIP() {
		return serveIP;
	}

	public void setServeIP(String serveIP) {
		this.serveIP = serveIP;
	}

	public String getRomoteIP() {
		return romoteIP;
	}

	public void setRomoteIP(String romoteIP) {
		this.romoteIP = romoteIP;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswerUserCode() {
		return answerUserCode;
	}

	public void setAnswerUserCode(String answerUserCode) {
		this.answerUserCode = answerUserCode;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

}