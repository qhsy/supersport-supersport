package com.uhutu.dcom.content.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 导航栏
 * 
 * @author xiegj
 *
 */
public class CnHomeNavMenuForApi extends CnHomeNavMenu {
	@ApiModelProperty(name = "文章类型(piclinkType为dzsd4107100110050002时此参数有效)", notes = "dzsd4107100110030001:文章 ,dzsd4107100110030002:文章(含视频),dzsd4107100110030003:图集(piclinkType为dzsd4107100110050002时此参数有效),dzsd4107100110030004:单图,dzsd4107100110030005:单视频", example = "dzsd4107100110030001")
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
