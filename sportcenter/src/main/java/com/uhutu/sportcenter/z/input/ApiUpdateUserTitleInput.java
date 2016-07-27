package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 更新用户title
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiUpdateUserTitleInput extends RootApiInput {
	
	@ApiModelProperty(value="头衔")
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
