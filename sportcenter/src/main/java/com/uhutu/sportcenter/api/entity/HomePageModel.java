package com.uhutu.sportcenter.api.entity;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.user.entity.UcUserinfoExt;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageModel {


	@ApiModelProperty(name = "用户信息", notes = "用户信息头像昵称等信息", example = "张嘉译个人信息")
	UcUserinfoExt ue = new UcUserinfoExt();

	@ApiModelProperty(name = "展示的内容基本信息", notes = "展示的内容基本信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	CnContentBasicinfo info = new CnContentBasicinfo();

	public UcUserinfoExt getUe() {
		return ue;
	}

	public void setUe(UcUserinfoExt ue) {
		this.ue = ue;
	}

	public CnContentBasicinfo getInfo() {
		return info;
	}

	public void setInfo(CnContentBasicinfo info) {
		this.info = info;
	}

	
}
