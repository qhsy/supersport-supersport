package com.uhutu.dcom.pay.z.request;

import com.uhutu.dcom.pay.z.common.OperType;
import com.uhutu.dcom.pay.z.common.TradeType;
import com.uhutu.dcom.pay.z.face.IPayRequest;

/**
 * 金币支付请求信息
 * @author 逄小帅
 *
 */
public class GoldCoinPayRequest implements IPayRequest {

	/*金币数量*/
	private long coinNum;
	
	/*交易类型*/
	private TradeType tradeType;
	
	/*操作类型*/
	private OperType operType;
	
	/*用户编号*/
	private String userCode;
	
	/*外部交易编号*/
	private String outCode;
	
	/*金币备注信息*/
	private String remark;

	public long getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(long coinNum) {
		this.coinNum = coinNum;
	}

	public TradeType getTradeType() {
		return tradeType;
	}

	public void setTradeType(TradeType tradeType) {
		this.tradeType = tradeType;
	}

	public OperType getOperType() {
		return operType;
	}

	public void setOperType(OperType operType) {
		this.operType = operType;
	}

	public String getOutCode() {
		return outCode;
	}

	public void setOutCode(String outCode) {
		this.outCode = outCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
