package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

public class ApiSpecialEffectRecordInput extends RootApiInput {

	@ApiModelProperty(name = "直播间编号", required = true, value = "编号", example = "v1.1.0")
	private String code;

	@ApiModelProperty(name = "特效编号", required = true, value = "特效编号", example = "tx001")
	private String seCode;

	@ApiModelProperty(name = "使用数量")
	private long num;

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeCode() {
		return seCode;
	}

	public void setSeCode(String seCode) {
		this.seCode = seCode;
	}

}
