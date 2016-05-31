package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分享内容
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiShareContentResult extends RootApiResult {
	
	@ApiModelProperty(value="缩略图")
	private String iconUrl;
	
	@ApiModelProperty(value="标题")
	private String title;
	
	@ApiModelProperty(value="内容缩写")
	private String content;

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
	
	

}
