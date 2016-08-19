package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信用户登录
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatUserLoginInput3 extends RootApiInput {
	
	@ApiModelProperty(value="授权登录后返回code")
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
