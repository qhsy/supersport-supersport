package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.RemarkInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 评论数据返回
 * 
 * @author 逄小帅
 *
 */
@ApiModel
public class ApiRemarkCountResult extends RootApiResult {

	@ApiModelProperty(value = "评论类型及数量")
	private List<RemarkInfo> list = new ArrayList<RemarkInfo>();

	public List<RemarkInfo> getList() {
		return list;
	}

	public void setList(List<RemarkInfo> list) {
		this.list = list;
	}

}
