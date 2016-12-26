package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事报名信息
 * @author 逄小帅
 *
 */
public class ApiMatchSignListInput extends RootApiInput {
	
	@ApiModelProperty(value="赛事编号")
	private String matchCode;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}
	
	

}
