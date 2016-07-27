package com.uhutu.sportcenter.z.input;

import java.math.BigDecimal;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 问答用户信息输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAppUpdateAnswerUserInput extends RootApiInput {
	
	@ApiModelProperty(value="状态",example="true:开通问答,false:关闭问答")
	private boolean openFlag;
	
	@ApiModelProperty(value="简介")
	private String ability;
	
	@ApiModelProperty(value="支付金额")
	private BigDecimal charge = BigDecimal.ZERO;

	public String getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = ability;
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public boolean isOpenFlag() {
		return openFlag;
	}

	public void setOpenFlag(boolean openFlag) {
		this.openFlag = openFlag;
	}	
	

}
