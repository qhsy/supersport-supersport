package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 用户搜索输入
 * @author 逄小帅
 *
 */
public class ApiSearchUserInput extends RootApiInput {
	
	@ApiModelProperty(value="用户昵称")
	private String nickName;
	
	@ApiModelProperty(name = "页码", value = "页码", example = "0")
	private int pagination = 0;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
