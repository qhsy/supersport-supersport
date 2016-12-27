package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 赛事信息输入参数
 * @author 逄小帅
 *
 */
public class ApiMatchInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="赛事编号")
	private String matchCode;
	
	@ApiModelProperty(value="宽度")
	private int width;

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

}
