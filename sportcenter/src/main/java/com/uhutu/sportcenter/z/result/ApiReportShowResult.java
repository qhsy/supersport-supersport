package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiReportShowResult extends RootApiResult {

	@ApiModelProperty(name = "活动名称", notes = "活动名称")
	private String title = "";

	@ApiModelProperty(name = "活动信息", notes = "活动信息")
	private List<Map<String, String>> list = new ArrayList<Map<String, String>>();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Map<String, String>> getList() {
		return list;
	}

	public void setList(List<Map<String, String>> list) {
		this.list = list;
	}

}
