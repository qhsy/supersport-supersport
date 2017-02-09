package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;
import com.uhutu.sportcenter.z.entity.UserBasicInfo;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容红包打赏人员
 * @author 逄小帅
 *
 */
public class ApiContentRedPackUserResult extends RootApiResult {
	
	@ApiModelProperty(name="是否存在下一页数据",value="是否存在下一页数据",example="true")
	private boolean  nextPageFlag= true;
	
	@ApiModelProperty(value="总共多少人打赏")
	private int total;
	
	@ApiModelProperty(value="打赏人员列表")
	List<UserBasicInfo> userBasicInfos = new ArrayList<UserBasicInfo>();

	public boolean isNextPageFlag() {
		return nextPageFlag;
	}

	public void setNextPageFlag(boolean nextPageFlag) {
		this.nextPageFlag = nextPageFlag;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<UserBasicInfo> getUserBasicInfos() {
		return userBasicInfos;
	}

	public void setUserBasicInfos(List<UserBasicInfo> userBasicInfos) {
		this.userBasicInfos = userBasicInfos;
	}

}
