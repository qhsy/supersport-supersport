package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息展示输入参数
 * 
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiForAttentionInput extends RootApiInput {

	@ApiModelProperty(value = "被关注的用户编号", notes = "用户编号", required = true)
	private String userCode = "";

	@ApiModelProperty(name = "是否关注", example = "0", required = true)
	private String flag = "";

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
