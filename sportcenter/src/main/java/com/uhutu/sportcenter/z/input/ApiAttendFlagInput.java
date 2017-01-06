package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 输入参数信息
 * @author 逄小帅
 *
 */
public class ApiAttendFlagInput extends RootApiInput {
	
	@ApiModelProperty(value="编号",notes="用户编号，直播房间号")
	private String code;
	
	@ApiModelProperty(value="操作标识", notes="live:直播")
	private String operFlag;

	public String getOperFlag() {
		return operFlag;
	}

	public void setOperFlag(String operFlag) {
		this.operFlag = operFlag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
