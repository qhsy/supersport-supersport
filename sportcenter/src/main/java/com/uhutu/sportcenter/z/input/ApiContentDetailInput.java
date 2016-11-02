package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详情展示
 * 
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiContentDetailInput extends RootApiInput {

	@ApiModelProperty(value = "内容编号", notes = "内容编号", required = true)
	private String content_code = "";

	@ApiModelProperty(value = "图片最大宽度", notes = "图片最大宽度(次参数为空，图片不压缩)", example = "1080")
	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public String getContent_code() {
		return content_code;
	}

	public void setContent_code(String content_code) {
		this.content_code = content_code;
	}

}
