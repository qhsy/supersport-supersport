package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容举报输入参数
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiComplainInfoInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="内容编号",required=true)
	private String contentCode;
	
	@ApiModelProperty(value="投诉原因",required=true)
	private String reasonCode;
	
	@ApiModelProperty(value="投诉备注信息")
	private String remark;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
