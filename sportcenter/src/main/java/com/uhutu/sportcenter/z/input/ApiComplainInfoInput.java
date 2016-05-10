package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容举报输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiComplainInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="内容编号",required=true)
	private String contentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}
	

}
