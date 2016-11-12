package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiSignPhotoResult extends RootApiResult {

	@ApiModelProperty(value = "证件")
	private List<String> li = new ArrayList<String>();

	public List<String> getLi() {
		return li;
	}

	public void setLi(List<String> li) {
		this.li = li;
	}

}
