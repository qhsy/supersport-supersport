package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 消息分享
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiShareContentInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号")
	private String contentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}
	
	

}
