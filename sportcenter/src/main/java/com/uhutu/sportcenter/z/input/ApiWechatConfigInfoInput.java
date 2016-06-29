package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信配置信息输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiWechatConfigInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="当前页面路径")
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
