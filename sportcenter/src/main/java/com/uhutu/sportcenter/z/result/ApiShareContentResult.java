package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分享内容
 * 
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiShareContentResult extends RootApiResult {

	@ApiModelProperty(value = "缩略图")
	private String iconUrl;

	@ApiModelProperty(value = "标题")
	private String title;

	@ApiModelProperty(value = "内容缩写")
	private String content;

	@ApiModelProperty(name = "分享的内容编号")
	private String code;

	@ApiModelProperty(name = "分享链接")
	private String url;

	@ApiModelProperty(name = "分享图片(兼容安卓)")
	private String cover;

	@ApiModelProperty(name = "分享内容(兼容安卓)")
	private String aboutDesc;
	
	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getAboutDesc() {
		return aboutDesc;
	}

	public void setAboutDesc(String aboutDesc) {
		this.aboutDesc = aboutDesc;
	}
	

}
