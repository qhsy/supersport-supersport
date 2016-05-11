package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 各种评论数量的输入
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRemarkCountInput extends RootApiInput {

	@ApiModelProperty(value="评论类型",example="remarkCount:评论数量,favorCoun:喜欢的数量")
	private String operFlag;

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}
	
}
