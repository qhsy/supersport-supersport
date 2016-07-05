package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人中心我答列表
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiAnswerInfoListInput extends RootApiInput {
	
	/*页码*/
	@ApiModelProperty(value="当前页页码")
	private int pagination;
	
	/*每页数量*/
	@ApiModelProperty(value="每页展示数量")
	private int pageNum;
	
	@ApiModelProperty(value="问题状态",example="默认全部, dzsd4888100110010001:待回答,dzsd4888100110010002:已回答,dzsd4888100110010003:已拒绝回答")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPagination() {
		return pagination;
	}

	public void setPagination(int pagination) {
		this.pagination = pagination;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
