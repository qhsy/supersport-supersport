package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 标签关联列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiLabelRelListInput extends RootApiInput {
	
	@ApiModelProperty(value="标签code",notes="标签code，逗号分割")
	private String tagCode;
	
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	@ApiModelProperty(value="封面宽度")
	private int wCover;
	
	@ApiModelProperty(value="内容宽度")
	private int wContent;
	
	@ApiModelProperty(value="类型",example="最新tab:newTab,最热tab:hotTab")
	private String type;

	public String getTagCode() {
		return tagCode;
	}

	public void setTagCode(String tagCode) {
		this.tagCode = tagCode;
	}
	
	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getwCover() {
		return wCover;
	}

	public void setwCover(int wCover) {
		this.wCover = wCover;
	}

	public int getwContent() {
		return wContent;
	}

	public void setwContent(int wContent) {
		this.wContent = wContent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
