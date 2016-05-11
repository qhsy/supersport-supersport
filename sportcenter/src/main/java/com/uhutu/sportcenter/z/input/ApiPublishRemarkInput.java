package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发布评论输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiPublishRemarkInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="内容编号",required=true)
	private String contentCode;
	
	@ApiModelProperty(value="评论内容",notes="评论内容",required=true)
	private String remark;
	
	@ApiModelProperty(value="父级评论编号",notes="针对评论的评论",required=true)
	private String parentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	
	

}
