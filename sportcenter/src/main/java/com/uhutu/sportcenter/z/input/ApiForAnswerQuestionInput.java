package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModelProperty;

/**
 * 回答信息
 *
 */
public class ApiForAnswerQuestionInput extends RootApiInput {
	@ApiModelProperty(name = "问题编号")
	private String code;

	@ApiModelProperty(name = "语音路径")
	private String url;

	@ApiModelProperty(name = "语音长度(秒)")
	private int lengh;

	@ApiModelProperty(name = "拒绝回答", notes = "true:拒绝回答,false:回答")
	private boolean refuse;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getLengh() {
		return lengh;
	}

	public void setLengh(int lengh) {
		this.lengh = lengh;
	}

	public boolean isRefuse() {
		return refuse;
	}

	public void setRefuse(boolean refuse) {
		this.refuse = refuse;
	}

}