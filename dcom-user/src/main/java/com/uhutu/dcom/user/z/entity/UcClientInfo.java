package com.uhutu.dcom.user.z.entity;

import javax.persistence.Entity;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 终端信息
 * 
 * @author xiegj
 *
 */
@Entity
public class UcClientInfo extends BaseEntity {

	@ZooData(value = "app版本信息")
	private String app_vision = "";

	@ZooData(value = "手机型号")
	private String model = "";

	@ZooData(value = "设备的唯一标识")
	private String uniqid = "";

	@ZooData(value = "设备的唯一编号")
	private String idfa = "";

	@ZooData(value = "mac地址")
	private String mac = "";

	@ZooData(value = "手机操作系统")
	private String os = "";

	@ZooData(value = "手机操作系统及版本")
	private String os_info = "";

	@ZooData(value = "渠道号")
	private String fromCode = "";

	@ZooData(value = "屏幕分辨率")
	private String screen = "";

	@ZooData(value = "运营商SIM卡国家码和网络码")
	private String op = "";

	@ZooData(value = "产品名称")
	private String product = "";

	@ZooData(value = "网络状态")
	private String net_type = "";

	@ZooData(value="用户编号")
	private String user_code="";
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

	public String getFromCode() {
		return fromCode;
	}

	public void setFromCode(String fromCode) {
		this.fromCode = fromCode;
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

	public String getUser_code() {
		return user_code;
	}

	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

}
