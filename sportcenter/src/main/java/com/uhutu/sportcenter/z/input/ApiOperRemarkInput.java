package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 操作输入参数
 * @author 逄小帅
 *
 */
public class ApiOperRemarkInput extends RootApiInput {
	
	@ApiModelProperty(value="评论内容编号")
	private String remarkCode;
	
	@ApiModelProperty(value="操作标识 DEL：删除")
	private String operFlag = "DEL";

	public String getRemarkCode() {
		return remarkCode;
	}

	public void setRemarkCode(String remarkCode) {
		this.remarkCode = remarkCode;
	}

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

}
