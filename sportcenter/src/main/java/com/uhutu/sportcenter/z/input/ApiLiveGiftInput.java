package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiLiveGiftInput extends RootApiInput {

	@ApiModelProperty(value = "礼物编号", required = true)
	private String giftCode;

	@ApiModelProperty(value = "房间编号", required = true)
	private String liveCode;

	@ApiModelProperty(value = "接受礼物人编号", required = true)
	private String reciveUserCode;

	@ApiModelProperty(value = "来源 dzsd4112100110020001:app订单,dzsd4112100110020002:wap订单", example = "dzsd4112100110020002", required = true)
	private String orderSource;

	@ApiModelProperty(value = "支付类型  dzsd4112100110040001:支付宝,dzsd4112100110040002:微信,dzsd4112100110040003:金币支付", example = "dzsd4112100110040002", required = true)
	private String payType;

	@ApiModelProperty(value = "服务ip(此参数无须输入)")
	private String serveIP;

	@ApiModelProperty(value = "终端IP(此参数无须输入)")
	private String romoteIP;

	public String getGiftCode() {
		return giftCode;
	}

	public void setGiftCode(String giftCode) {
		this.giftCode = giftCode;
	}

	public String getLiveCode() {
		return liveCode;
	}

	public void setLiveCode(String liveCode) {
		this.liveCode = liveCode;
	}

	public String getReciveUserCode() {
		return reciveUserCode;
	}

	public void setReciveUserCode(String reciveUserCode) {
		this.reciveUserCode = reciveUserCode;
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

}
