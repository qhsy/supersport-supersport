package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 内容相关操作接口
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiOperContentInput extends RootApiInput {
	
	@ApiModelProperty(value="操作标识",example="delete:逻辑删除 打赏红包:redpack")
	private String operFlag;
	
	@ApiModelProperty(value="内容编号")
	private String contentCode;

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
