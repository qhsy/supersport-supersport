package com.uhutu.sportcenter.z.entity;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

/**
 * 首页内容实例对象
 *
 * @author xiegj
 * 
 */
public class HomePageThird {

	@ApiModelProperty(name = "栏目类型", notes = "dzsd4107100110110001:推荐栏,dzsd4107100110110002:两栏内容4:3,dzsd4107100110110003:一栏内容16:9", example = "dzsd4107100110110001")
	private String showType = "";

	@ApiModelProperty(name = "栏目信息", notes = "栏目信息", example = "栏目信息")
	private CnHomeItemForApi item = new CnHomeItemForApi();

	@ApiModelProperty(name = "内容信息", notes = "内容信息", example = "张嘉译拍摄《营盘镇警事》杀青新闻")
	List<ContentBasicinfoForApi> infos = new ArrayList<ContentBasicinfoForApi>();

	@ApiModelProperty(name = "推荐信息", notes = "推荐信息")
	List<AdvertiseDetailForThirdHomePageApi> recommens = new ArrayList<AdvertiseDetailForThirdHomePageApi>();

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public List<ContentBasicinfoForApi> getInfos() {
		return infos;
	}

	public void setInfos(List<ContentBasicinfoForApi> infos) {
		this.infos = infos;
	}

	public CnHomeItemForApi getItem() {
		return item;
	}

	public void setItem(CnHomeItemForApi item) {
		this.item = item;
	}

	public List<AdvertiseDetailForThirdHomePageApi> getRecommens() {
		return recommens;
	}

	public void setRecommens(List<AdvertiseDetailForThirdHomePageApi> recommens) {
		this.recommens = recommens;
	}

}
