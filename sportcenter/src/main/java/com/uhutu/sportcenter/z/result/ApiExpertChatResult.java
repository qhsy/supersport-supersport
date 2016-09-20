package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentShowModel;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 达人专访
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiExpertChatResult extends RootApiResult {
	
	@ApiModelProperty(value="达人专访列表信息")
	private List<ContentShowModel> contentShowModels = new ArrayList<ContentShowModel>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= false;

	public List<ContentShowModel> getContentShowModels() {
		return contentShowModels;
	}

	public void setContentShowModels(List<ContentShowModel> contentShowModels) {
		this.contentShowModels = contentShowModels;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
