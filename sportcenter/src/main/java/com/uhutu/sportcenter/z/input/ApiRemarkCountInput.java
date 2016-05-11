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

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
