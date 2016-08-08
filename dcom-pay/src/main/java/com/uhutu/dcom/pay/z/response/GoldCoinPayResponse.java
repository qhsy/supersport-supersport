package com.uhutu.dcom.pay.z.response;

import com.uhutu.dcom.pay.z.face.IPayResponse;
import com.uhutu.zoocom.model.MResult;

/**
 * 金币支付响应信息
 * @author 逄小帅
 *
 */
public class GoldCoinPayResponse extends MResult implements IPayResponse {
	
	/*金币余额*/
	private long balance = 0;
	
	/*是否可扣*/
	private boolean operFlag = true;
	
	/*交易流水编号*/
	private String flowNO;

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public boolean isOperFlag() {
		return operFlag;
	}

	public void setOperFlag(boolean operFlag) {
		this.operFlag = operFlag;
	}

	public String getFlowNO() {
		return flowNO;
	}

	public void setFlowNO(String flowNO) {
		this.flowNO = flowNO;
	}

}
