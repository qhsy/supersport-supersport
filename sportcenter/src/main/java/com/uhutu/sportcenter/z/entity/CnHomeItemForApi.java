package com.uhutu.sportcenter.z.entity;

import com.uhutu.dcom.content.z.entity.CnHomeItem;

import io.swagger.annotations.ApiModelProperty;

/**
 * 栏目数据模型
 * 
 * @author xiegj
 *
 */
public class CnHomeItemForApi extends CnHomeItem {

	@ApiModelProperty(name = "跳转类")
	private JumpTypeData jump;

	public JumpTypeData getJump() {
		return jump;
	}

	public void setJump(JumpTypeData jump) {
		this.jump = jump;
	}

}
