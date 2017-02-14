package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.RedPackInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 返回结果
 * @author 逄小帅
 *
 */
public class ApiContentRedPackInfoResult extends RootApiResult {
	
	@ApiModelProperty(value="红包信息")
	private List<RedPackInfo> redPackInfos = new ArrayList<RedPackInfo>();

	public List<RedPackInfo> getRedPackInfos() {
		return redPackInfos;
	}

	public void setRedPackInfos(List<RedPackInfo> redPackInfos) {
		this.redPackInfos = redPackInfos;
	}

}
