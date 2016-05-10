package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 编辑推荐内容
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiContentRecommInput extends RootApiInput {
	
	@ApiModelProperty(value="内容编号",notes="推荐的内容编号")
	private String contentCode;

	public String getContentCode() {
		return contentCode;
	}

	public void setContentCode(String contentCode) {
		this.contentCode = contentCode;
	}

}
