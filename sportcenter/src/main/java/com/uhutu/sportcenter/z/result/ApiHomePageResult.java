package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.HomePageModel;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiHomePageResult extends RootApiResult {

	@ApiModelProperty(name = "首页展示实体数组", notes = "首页展示实体数组", example = "01")
	private List<HomePageModel> list = new ArrayList<HomePageModel>();

	@ApiModelProperty(value = "是否还有前一天数据", notes = "是否还有前一天数据", example = "true", required = true)
	private boolean nextflag = true;

	public List<HomePageModel> getList() {
		return list;
	}

	public void setList(List<HomePageModel> list) {
		this.list = list;
	}

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

}
