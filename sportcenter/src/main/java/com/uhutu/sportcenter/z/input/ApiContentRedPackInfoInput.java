package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 输入参数
 * @author 逄小帅
 *
 */
public class ApiContentRedPackInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="索引 默认：0")
	private int index = 0;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	

}
