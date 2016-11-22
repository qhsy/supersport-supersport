package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 内容基本信息数据模型
 * 
 * @author xiegj
 *
 */
public class ContentBasicinfoForTypeApi extends ContentBasicinfoForApi {

	@ApiModelProperty(name = "直播标志 dzsd4107100110100001:直播中，dzsd4107100110100002:回放", notes = "直播标志 dzsd4107100110100001:直播中，dzsd4107100110100002:回放")
	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
