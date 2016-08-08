package com.uhutu.dcom.pay.z.common;

/**
 * 操作类型
 * @author 逄小帅
 *
 */
public enum OperType {
	
	/**充值*/
	COIN_CHARGE("金币充值"),
	
	/**偷听支付*/
	PAY_LISTEN("问达偷听金币支付"),
	
	/**金币查询*/
	COIN_QUERY("金币查询");
	
	private String remark;
	
	private OperType(String remark) {
		
		this.remark = remark;
		
	}

	public String getRemark() {
		return remark;
	}

}
