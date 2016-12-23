package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打赏人员搜索
 * @author 逄小帅
 *
 */
public class ApiPackUserSearchInput extends RootApiInput {
	
	@ApiModelProperty(value="搜索关键词")
	private String keyName;
	
	@ApiModelProperty(name = "页码", value = "页码", example = "0")
	private int pagination = 0;

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

}
