package com.uhutu.sportcenter.api.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageModel {

	@ApiModelProperty(name = "用户信息", notes = "用户信息头像昵称等信息", example = "张嘉译个人信息")
	UserinfoExtForApi ue = new UserinfoExtForApi();

	@ApiModelProperty(name = "展示的内容基本信息", notes = "展示的内容基本信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	ContentBasicinfoForApi info = new ContentBasicinfoForApi();

	public UserinfoExtForApi getUe() {
		return ue;
	}

	public void setUe(UserinfoExtForApi ue) {
		this.ue = ue;
	}

	public ContentBasicinfoForApi getInfo() {
		return info;
	}

	public void setInfo(ContentBasicinfoForApi info) {
		this.info = info;
	}

}
