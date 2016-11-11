package com.uhutu.sportcenter.z.input;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.UcSignInfoForApi;
import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApiForAnswerOrderInput extends RootApiInput {

	@ApiModelProperty(value = "商品编号dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准 或者问答编号", notes = "商品编号", example = "dzsd4107100510020001:个人标准,dzsd4107100510020002:个人业余,dzsd4107100510020003:团体标准 或者问答编号", required = true)
	private String answerCode = "";

	@ApiModelProperty(value = "订单类型 dzsd4112100110010003:问达订单,dzsd4112100110010004:偷听订单,dzsd4112100110010005:ThrowDown", example = "dzsd4112100110010004", required = true)
	private String orderType;

	@ApiModelProperty(value = "来源 dzsd4112100110020001:app订单,dzsd4112100110020002:wap订单", example = "dzsd4112100110020002", required = true)
	private String orderSource;

	@ApiModelProperty(value = "支付类型  dzsd4112100110040001:支付宝,dzsd4112100110040002:微信,dzsd4112100110040003:金币支付", example = "dzsd4112100110040002", required = true)
	private String payType;

	@ApiModelProperty(value = "app版本信息")
	private String appVersion;

	@ApiModelProperty(value = "服务ip(此参数无须输入)")
	private String serveIP;

	@ApiModelProperty(value = "终端IP(此参数无须输入)")
	private String romoteIP;

	@ApiModelProperty(value = "报名信息")
	private List<UcSignInfoForApi> signs = new ArrayList<UcSignInfoForApi>();

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

	public List<UcSignInfoForApi> getSigns() {
		return signs;
	}

	public void setSigns(List<UcSignInfoForApi> signs) {
		this.signs = signs;
	}

}
