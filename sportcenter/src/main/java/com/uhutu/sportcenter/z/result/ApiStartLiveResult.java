package com.uhutu.sportcenter.z.result;

import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

/**
 * 开始直播处理结果
 * @author 逄小帅
 *
 */
public class ApiStartLiveResult extends RootApiResult {

	@ApiModelProperty(name = "文章编号")
	private String contentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}
	
}
