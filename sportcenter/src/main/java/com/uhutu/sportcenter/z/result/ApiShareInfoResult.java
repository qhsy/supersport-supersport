package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiShareInfoResult extends RootApiResult {

	@ApiModelProperty(name = "分享的内容编号")
	private String code;

	@ApiModelProperty(name = "分享标题")
	private String title;

	@ApiModelProperty(name = "分享图片")
	private String cover;

	@ApiModelProperty(name = "分享链接")
	private String url;

	@ApiModelProperty(name = "分享内容")
	private String aboutDesc;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}

}
