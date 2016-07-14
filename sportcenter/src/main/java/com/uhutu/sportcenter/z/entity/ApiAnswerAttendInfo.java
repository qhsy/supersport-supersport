package com.uhutu.sportcenter.z.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * 消息通知信息
 * @author 逄小帅
 *
 */
public class ApiAnswerAttendInfo extends UserBasicInfo {
	
	@ApiModelProperty(value="头衔")
	private String title;
	
	@ApiModelProperty(value="偷听次数")
	private long total;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
	
}
