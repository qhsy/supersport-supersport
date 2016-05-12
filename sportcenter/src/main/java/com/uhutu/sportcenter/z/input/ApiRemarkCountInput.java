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

	@ApiModelProperty(value="内容编号",example="nr001")
	private String contentCode;
	
	@ApiModelProperty(value="评论类型",example="remarkCount:评论数量,favorCount:喜欢的数量,空默认为全部")
	private String type;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
