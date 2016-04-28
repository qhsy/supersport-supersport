package com.uhutu.sportcenter.api.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 设置用户喜欢运动
 * @author pang_jhui
 *
 */
public class ApiSetUserFavoerInput extends RootApiInput {
	
	@ApiModelProperty(value="运动分类集合" , example="以|分割 例如：002|003|004")
	private String catagoryCodes;

	/**
	 * 获取分类编码集合
	 * @return
	 */
	public String getCatagoryCodes() {
		return catagoryCodes;
	}

	/**
	 * 设置分类编码集合
	 * @param catagoryCodes
	 */
	public void setCatagoryCodes(String catagoryCodes) {
		this.catagoryCodes = catagoryCodes;
	}

}
