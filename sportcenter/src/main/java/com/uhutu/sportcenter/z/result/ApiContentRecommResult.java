package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.ContentRecommInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容推荐处理结果
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiContentRecommResult extends RootApiResult {
	
	@ApiModelProperty(value="编辑推荐内容信息",notes="推荐内容")
	private ContentRecommInfo contentRecommInfo;

	public ContentRecommInfo getContentRecommInfo() {
		return contentRecommInfo;
	}

	public void setContentRecommInfo(ContentRecommInfo contentRecommInfo) {
		this.contentRecommInfo = contentRecommInfo;
	}

}
