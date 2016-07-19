package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 翘臀大赛-实力派
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiButtockLapListResult extends RootApiResult {
	
	@ApiModelProperty(value="返回结果")
	private List<ContentBasicinfoForApi> buttockLapList = new ArrayList<ContentBasicinfoForApi>();
	
	@ApiModelProperty(value="是否有下页数据")
	private boolean nextflag = false;

	public boolean isNextflag() {
		return nextflag;
	}

	public void setNextflag(boolean nextflag) {
		this.nextflag = nextflag;
	}

	public List<ContentBasicinfoForApi> getButtockLapList() {
		return buttockLapList;
	}

	public void setButtockLapList(List<ContentBasicinfoForApi> buttockLapList) {
		this.buttockLapList = buttockLapList;
	}

}
