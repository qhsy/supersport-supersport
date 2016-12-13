package com.uhutu.sportcenter.z.entity;

import java.math.BigDecimal;

import com.uhutu.zoodata.dbbase.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 人员打赏金额信息
 * 
 * @author 逄小帅
 *
 */
public class RedPackUserForApi extends BaseEntity {

	@ApiModelProperty(name = "接受打赏者昵称", notes = "接受打赏者昵称")
	private String userCode;

	@ApiModelProperty(name = "分成比例1~100", notes = "分成比例1~100")
	private BigDecimal scale;

	@ApiModelProperty(name = "排序", notes = "排序")
	private int sort;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public BigDecimal getScale() {
		return scale;
	}

	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
