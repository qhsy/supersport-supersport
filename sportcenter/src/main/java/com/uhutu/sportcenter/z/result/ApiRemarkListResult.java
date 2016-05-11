package com.uhutu.sportcenter.z.result;

import java.util.List;

import com.uhutu.sportcenter.z.entity.ContentRemarkInfo;
import com.uhutu.zoocom.root.RootApiResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论列表返回结果
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRemarkListResult extends RootApiResult {
	
	@ApiModelProperty(value="评论信息")
	private List<ContentRemarkInfo> contentRemarkInfo;

	public List<ContentRemarkInfo> getContentRemarkInfo() {
		return contentRemarkInfo;
	}

	public void setContentRemarkInfo(List<ContentRemarkInfo> contentRemarkInfo) {
		this.contentRemarkInfo = contentRemarkInfo;
	}

}
