package com.uhutu.sportcenter.z.result;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 结束直播
 * 
 * @author xiegj
 *
 */
@ApiModel
public class ApiLiveVideoHeartResult extends RootApiResult {

	@ApiModelProperty(name = "本次直播打赏总金额")
	private BigDecimal money = BigDecimal.ZERO;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
