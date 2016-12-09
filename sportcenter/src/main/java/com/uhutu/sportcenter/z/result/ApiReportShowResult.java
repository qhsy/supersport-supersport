package com.uhutu.sportcenter.z.result;

import java.util.HashMap;
import java.util.Map;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiReportShowResult extends RootApiResult {

	@ApiModelProperty(name = "活动名称", notes = "活动名称")
	private String title = "";

	@ApiModelProperty(name = "活动信息", notes = "活动信息")
	private Map<String, String> map = new HashMap<String, String>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	};

}
