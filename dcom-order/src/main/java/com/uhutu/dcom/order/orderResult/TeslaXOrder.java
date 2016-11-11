package com.uhutu.dcom.order.orderResult;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.order.model.TeslaModelStatus;
import com.uhutu.dcom.order.z.entity.OcOrderActivity;
import com.uhutu.dcom.order.z.entity.OcOrderDetail;
import com.uhutu.dcom.order.z.entity.OcOrderInfo;
import com.uhutu.dcom.order.z.entity.OcOrderPay;
import com.uhutu.dcom.user.z.entity.UcSignInfo;

import io.swagger.annotations.ApiModelProperty;

public class TeslaXOrder {

	@ApiModelProperty(name = "订单主信息")
	private OcOrderInfo orderInfo = new OcOrderInfo();

	@ApiModelProperty(name = "订单明细信息")
	private List<OcOrderDetail> detail = new ArrayList<OcOrderDetail>();

	@ApiModelProperty(name = "订单支付信息")
	private List<OcOrderPay> pay = new ArrayList<OcOrderPay>();

	@ApiModelProperty(name = "订单标记")
	private TeslaModelStatus status = new TeslaModelStatus();

	@ApiModelProperty(name = "活动信息")
	private List<OcOrderActivity> activitys = new ArrayList<OcOrderActivity>();

	@ApiModelProperty(name = "报名信息")
	private UcSignInfo sign = new UcSignInfo();

	public TeslaModelStatus getStatus() {
		return status;
	}

	public void setStatus(TeslaModelStatus status) {
		this.status = status;
	}

	public OcOrderInfo getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(OcOrderInfo orderInfo) {
		this.orderInfo = orderInfo;
	}

	public List<OcOrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OcOrderDetail> detail) {
		this.detail = detail;
	}

	public List<OcOrderPay> getPay() {
		return pay;
	}

	public void setPay(List<OcOrderPay> pay) {
		this.pay = pay;
	}

	public List<OcOrderActivity> getActivitys() {
		return activitys;
	}

	public void setActivitys(List<OcOrderActivity> activitys) {
		this.activitys = activitys;
	}

	public UcSignInfo getSign() {
		return sign;
	}

	public void setSign(UcSignInfo sign) {
		this.sign = sign;
	}

}
