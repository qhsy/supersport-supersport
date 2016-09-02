package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ThemePageModel;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiThemePageResult extends RootApiResult {

	@ApiModelProperty(name = "专题编号")
	private String code = "";

	@ApiModelProperty(name = "专题名称")
	private String name = "";

	@ApiModelProperty(name = "专题封面")
	private String cover = "";

	@ApiModelProperty(name = "专题简介")
	private String aboutDesc = "";

	@ApiModelProperty(name = "是否分享")
	private boolean shareFlag = false;

	@ApiModelProperty(name = "详情信息")
	List<ThemePageModel> models = new ArrayList<ThemePageModel>();

	@ApiModelProperty(name = "达人信息")
	List<ThemePageModel> recomms = new ArrayList<ThemePageModel>();

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
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

	public List<ThemePageModel> getModels() {
		return models;
	}

	public void setModels(List<ThemePageModel> models) {
		this.models = models;
	}

	public boolean isShareFlag() {
		return shareFlag;
	}

	public void setShareFlag(boolean shareFlag) {
		this.shareFlag = shareFlag;
	}

	public List<ThemePageModel> getRecomms() {
		return recomms;
	}

	public void setRecomms(List<ThemePageModel> recomms) {
		this.recomms = recomms;
	}

}
