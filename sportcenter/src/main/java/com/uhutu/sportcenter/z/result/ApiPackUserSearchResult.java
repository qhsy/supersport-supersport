package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.z.entity.PackSeachUserInfo;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModelProperty;

/**
 * 打赏人员搜索列表
 * @author 逄小帅
 *
 */
public class ApiPackUserSearchResult extends RootApiResult {
	
	@ApiModelProperty(value="搜索结果列表")
	private List<PackSeachUserInfo> seachUserInfos = new ArrayList<PackSeachUserInfo>();
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;

	public List<PackSeachUserInfo> getSeachUserInfos() {
		return seachUserInfos;
	}

	public void setSeachUserInfos(List<PackSeachUserInfo> seachUserInfos) {
		this.seachUserInfos = seachUserInfos;
	}

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

}
