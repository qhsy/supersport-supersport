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
public class ApiContentTypeInput extends RootApiInput {

	@ApiModelProperty(value = "页数", notes = "页数", required = true)
	private int num;

	@ApiModelProperty(value = "宽度", required = true)
	private int width;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
