package com.uhutu.sportcenter.z.entity;

import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnLiveVideoDetailForApi;

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

	@ApiModelProperty(name = "直播信息 当contentType为dzsd4107100110030007时，取本直播参数", notes = "直播信息 当contentType为dzsd4107100110030007时，取本直播参数")
	CnLiveVideoDetailForApi liveVideoDetailForApi = new CnLiveVideoDetailForApi();

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

	public CnLiveVideoDetailForApi getLiveVideoDetailForApi() {
		return liveVideoDetailForApi;
	}

	public void setLiveVideoDetailForApi(CnLiveVideoDetailForApi liveVideoDetailForApi) {
		this.liveVideoDetailForApi = liveVideoDetailForApi;
	}

}
