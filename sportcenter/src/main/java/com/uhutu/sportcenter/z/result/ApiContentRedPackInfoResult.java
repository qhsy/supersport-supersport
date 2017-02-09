package com.uhutu.sportcenter.z.result;

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
	private RedPackInfo redPackInfo = new RedPackInfo();
	
	@ApiModelProperty(value="下次索引值")
	private int nextIndex = 0;

	public RedPackInfo getRedPackInfo() {
		return redPackInfo;
	}

	public void setRedPackInfo(RedPackInfo redPackInfo) {
		this.redPackInfo = redPackInfo;
	}

	public int getNextIndex() {
		return nextIndex;
	}

	public void setNextIndex(int nextIndex) {
		this.nextIndex = nextIndex;
	}

}
