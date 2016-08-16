package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 金币流水信息
 * @author 逄小帅
 *
 */
public class PaCoinFlowInfo {
	
	@ApiModelProperty(value = "流水编号")
	private String code;
	
	@ApiModelProperty(value = "交易类型")
	private String tradeType;
	
	@ApiModelProperty(value = "交易数量")
	private long tradeNum;
	
	@ApiModelProperty(value = "外部编号")
	private String outCode;
	
	@ApiModelProperty(value = "备注信息")
	private String remark;
	
	@ApiModelProperty(value = "操作类型")
	private String operType;
	
	@ApiModelProperty(value = "用户编号")
	private String userCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public long getTradeNum() {
		return tradeNum;
	}

	public void setTradeNum(long tradeNum) {
		this.tradeNum = tradeNum;
	}

	public String getOutCode() {
		return outCode;
	}

	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
