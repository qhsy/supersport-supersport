package com.uhutu.sportcenter.z.input;

import com.uhutu.zoocom.root.RootApiInput;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人中心我问列表信息
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiQuestionInfoListInput extends RootApiInput {
	
	/*页码*/
	@ApiModelProperty(value="当前页码")
	private int pagination;
	
	/*每页数量*/
	@ApiModelProperty(value="每页展示的数量")
	private int pageNum;

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
