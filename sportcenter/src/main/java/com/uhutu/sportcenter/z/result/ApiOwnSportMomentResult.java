package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.extend.sms.RootApiResult;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;

import io.swagger.annotations.ApiModelProperty;

/**
 * 我发布的运动时刻
 * @author 逄小帅
 *
 */
public class ApiOwnSportMomentResult extends RootApiResult {
	
	@ApiModelProperty(value = "运动时刻信息")
	private List<ContentBasicinfoForApi> moments = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<ContentBasicinfoForApi> getMoments() {
		return moments;
	}

	public void setMoments(List<ContentBasicinfoForApi> moments) {
		this.moments = moments;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
