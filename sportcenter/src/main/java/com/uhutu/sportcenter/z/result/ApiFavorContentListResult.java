package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户喜欢内容列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiFavorContentListResult extends RootApiResult {
	
	@ApiModelProperty(value="用户喜欢的内容列表")
	private List<ContentBasicinfoForApi> contentInfoList = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public List<ContentBasicinfoForApi> getContentInfoList() {
		return contentInfoList;
	}

	public void setContentInfoList(List<ContentBasicinfoForApi> contentInfoList) {
		this.contentInfoList = contentInfoList;
	}

}
