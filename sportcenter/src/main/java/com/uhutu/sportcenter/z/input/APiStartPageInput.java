package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class APiStartPageInput extends RootApiInput {

	@ApiModelProperty(value = "app版本信息", notes = "app版本信息", required = true, example = "1.0.0")
	private String app_vision = "";

	@ApiModelProperty(value = "手机型号", notes = "手机型号", example = "mi3")
	private String model = "";

	@ApiModelProperty(value = "设备的唯一标识", notes = "设备的唯一标识", example = "advertisingIdentifier")
	private String uniqid = "";

	@ApiModelProperty(value = "设备的唯一编号", notes = "设备的唯一编号", example = "advertisingIdentifier")
	private String idfa = "";

	@ApiModelProperty(value = "mac地址", notes = "mac地址", example = "mac")
	private String mac = "";

	@ApiModelProperty(value = "手机操作系统", notes = "手机操作系统", example = "ios")
	private String os = "";

	@ApiModelProperty(value = "手机操作系统及版本", notes = "手机操作系统及版本", example = "os_info")
	private String os_info = "";

	@ApiModelProperty(value = "渠道号", notes = "渠道号", example = "9100701")
	private String from = "";

	@ApiModelProperty(value = "屏幕分辨率", notes = "屏幕分辨率", example = "800x480")
	private String screen = "";

	@ApiModelProperty(value = "运营商SIM卡国家码和网络码", notes = "运营商SIM卡国家码和网络码", example = "46001")
	private String op = "";

	@ApiModelProperty(value = "产品名称", notes = "产品名称", example = "56mv_phone")
	private String product = "";

	@ApiModelProperty(value = "网络状态", notes = "网络状态", example = "wifi")
	private String net_type = "";

	@ApiModelProperty(value = "百度云推送id", notes = "百度云推送id", example = "wifi")
	private String channelId = "";

	public String getApp_vision() {
		return app_vision;
	}

	public void setApp_vision(String app_vision) {
		this.app_vision = app_vision;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getUniqid() {
		return uniqid;
	}

	public void setUniqid(String uniqid) {
		this.uniqid = uniqid;
	}

	public String getIdfa() {
		return idfa;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getOs_info() {
		return os_info;
	}

	public void setOs_info(String os_info) {
		this.os_info = os_info;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getNet_type() {
		return net_type;
	}

	public void setNet_type(String net_type) {
		this.net_type = net_type;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

}
