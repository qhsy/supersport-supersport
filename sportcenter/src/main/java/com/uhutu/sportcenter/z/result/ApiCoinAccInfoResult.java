package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金币账户信息结果
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiCoinAccInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="金币数量")
	private long coinNum;

	public long getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(long coinNum) {
		this.coinNum = coinNum;
	}
	

}
