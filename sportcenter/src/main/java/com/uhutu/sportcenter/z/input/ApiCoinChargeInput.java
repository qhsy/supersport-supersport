package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 金币充值
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiCoinChargeInput extends RootApiInput {
	
	@ApiModelProperty(value="金币数量")
	private long coinNum;

	public long getCoinNum() {
		return coinNum;
	}

	public void setCoinNum(long coinNum) {
		this.coinNum = coinNum;
	}

}
