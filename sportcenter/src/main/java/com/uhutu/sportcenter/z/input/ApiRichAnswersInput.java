package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 才华排行
 * 
 * @author xiegj
 *
 */
public class ApiRichAnswersInput extends RootApiInput {

	@ApiModelProperty(value = "页数(第一页开始)", required = true)
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
