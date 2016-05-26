package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 意见反馈input
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiMsgAdviceInput extends RootApiInput {
	
	@ApiModelProperty(value="投诉内容")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
