package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 昵称校验
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiVerifyNickNameInput extends RootApiInput {
	
	@ApiModelProperty(value="昵称")
	private String nickName;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	

}
