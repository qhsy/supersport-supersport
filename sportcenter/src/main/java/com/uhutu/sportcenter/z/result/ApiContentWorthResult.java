package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForTypeApi;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容详情
 * 
 * @author pang_jhui
 *
 */
@ApiModel
public class ApiContentWorthResult extends RootApiResult {

	@ApiModelProperty(value = "分类名称", notes = "分类名称")
	private String name;

	@ApiModelProperty(name = "运动时刻列表", value = "运动时刻列表", example = "")
	private List<ContentBasicinfoForTypeApi> moments = new ArrayList<ContentBasicinfoForTypeApi>();

	@ApiModelProperty(value = "是否存在下一页", notes = "是否存在下一页")
	private boolean nextFlag = false;

	public List<ContentBasicinfoForTypeApi> getMoments() {
		return moments;
	}

	public void setMoments(List<ContentBasicinfoForTypeApi> moments) {
		this.moments = moments;
	}

	public boolean isNextFlag() {
		return nextFlag;
	}

	public void setNextFlag(boolean nextFlag) {
		this.nextFlag = nextFlag;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
