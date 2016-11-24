package com.uhutu.sportcenter.z.entity;

import com.uhutu.dcom.content.z.entity.CnContentDetail;

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

	@ApiModelProperty(name = "详情", notes = "详情")
	CnContentDetail detail = new CnContentDetail();

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public CnContentDetail getDetail() {
		return detail;
	}

	public void setDetail(CnContentDetail detail) {
		this.detail = detail;
	}

}
