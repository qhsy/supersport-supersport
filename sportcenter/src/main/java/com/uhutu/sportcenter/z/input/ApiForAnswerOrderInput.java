package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiForAnswerOrderInput extends RootApiInput {

	@ApiModelProperty(value = "问题编号", notes = "问达问题编号", example = "WTBH0001", required = true)
	private String answerCode = "";

	@ApiModelProperty(value = "问答类型", notes = "dzsd4112100110010003:问达订单,dzsd4112100110010004:偷听订单", example = "dzsd4112100110010004", required = true)
	private String orderType;

	@ApiModelProperty(value = "来源", notes = "dzsd4112100110020001:app订单,dzsd4112100110020002:wap订单", example = "dzsd4112100110020002", required = true)
	private String orderSource;

	@ApiModelProperty(value = "支付类型", notes = "dzsd4112100110040001:支付宝,dzsd4112100110040002:微信", example = "dzsd4112100110040002", required = true)
	private String payType;

	@ApiModelProperty(value = "app版本信息")
	private String appVersion;

	public String getAnswerCode() {
		return answerCode;
	}

	public void setAnswerCode(String answerCode) {
		this.answerCode = answerCode;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

}
