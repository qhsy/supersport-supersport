package com.uhutu.sportcenter.api.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 展示广告信息
 * 
 * @author xiegj
 *
 */
public class AdvertiseMent {

	@ApiModelProperty(name = "广告编号", notes = "广告编号", example = "gg01")
	private String code = "";

	@ApiModelProperty(name = "广告类型", notes = " 01:轮播图，03:广告位", example = "01")
	private String type = "";

	@ApiModelProperty(name = "广告图片信息", notes = "广告图片信息")
	List<AdvertiseDetailForApi> details = new ArrayList<AdvertiseDetailForApi>();

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
