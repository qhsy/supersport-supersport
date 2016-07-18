package com.uhutu.dcom.answer.z.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.uhutu.zoocom.baseannotation.ZooData;
import com.uhutu.zoocom.define.DefineWebElement;
import com.uhutu.zoocom.define.DefineWebInc;
import com.uhutu.zoocom.define.DefineWebPage;
import com.uhutu.zoodata.dbbase.BaseEntity;

/**
 * 微信退款任务
 * 
 * @author xiegj
 *
 */
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class AwAnswerRefundJob extends BaseEntity {

	@ZooData(value = "退款编号", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String code;

	@ZooData(value = "退款类型", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=dzsd488810011004" }, sort = { DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String type;

	@ZooData(value = "订单编号", sort = { DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String orderCode;

	@ZooData(value = "收款人", element = DefineWebElement.Model, inc = {
			DefineWebInc.Web_Component + "=dzcw451010010001" }, sort = { DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String userCode;

	@ZooData(value = "收款人微信授权登录标识", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	@Column(length = 50)
	private String wechatOpenId;

	@ZooData(value = "退款总金额 (RMB)", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Edit + "=0" })
	private BigDecimal amount;

	@ZooData(value = "未退款金额 (RMB)", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0",
			DefineWebPage.Page_Edit + "=0" })
	private BigDecimal unAmount;

	@ZooData(value = "已退金额", sort = { DefineWebPage.Page_Query + "=0" })
	private BigDecimal alAmount;

	@ZooData(value = "是否退款完成", element = DefineWebElement.Select, inc = {
			DefineWebInc.System_Define + "=10" }, demo = "0:已完成,1:未完成")
	@Column(length = 50)
	private String status;

	@ZooData(value = "备注", sort = { DefineWebPage.Page_Query + "=0", DefineWebPage.Page_Grid + "=0" })
	@Column(length = 255)
	private String remark;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getUnAmount() {
		return unAmount;
	}

	public void setUnAmount(BigDecimal unAmount) {
		this.unAmount = unAmount;
	}

	public BigDecimal getAlAmount() {
		return alAmount;
	}

	public void setAlAmount(BigDecimal alAmount) {
		this.alAmount = alAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
