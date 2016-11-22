package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.CnContentType;
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
public class ApiContentTypeResult extends RootApiResult {

	@ApiModelProperty(value = "分类信息", notes = "分类信息")
	List<CnContentType> types = new ArrayList<CnContentType>();

	@ApiModelProperty(name = "运动时刻列表", value = "运动时刻列表", example = "")
	private List<ContentBasicinfoForTypeApi> moments = new ArrayList<ContentBasicinfoForTypeApi>();

	@ApiModelProperty(value = "是否存在下一页", notes = "是否存在下一页")
	private boolean nextFlag = false;

	public List<CnContentType> getTypes() {
		return types;
	}

	public void setTypes(List<CnContentType> types) {
		this.types = types;
	}

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

}
