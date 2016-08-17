package com.uhutu.sportcenter.z.result;

import com.uhutu.sportcenter.z.entity.LabelContentInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 标签关联列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiLabelRelListResult extends RootApiResult {
	
	@ApiModelProperty(value="封面")
	private String cover;
	
	@ApiModelProperty(value="内容")
	private String content;
	
	@ApiModelProperty(value="最新内容")
	private LabelContentInfo newContent = new LabelContentInfo();
	
	@ApiModelProperty(value="最热内容")
	private LabelContentInfo hotContent = new LabelContentInfo();

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LabelContentInfo getNewContent() {
		return newContent;
	}

	public void setNewContent(LabelContentInfo newContent) {
		this.newContent = newContent;
	}

	public LabelContentInfo getHotContent() {
		return hotContent;
	}

	public void setHotContent(LabelContentInfo hotContent) {
		this.hotContent = hotContent;
	}

}
