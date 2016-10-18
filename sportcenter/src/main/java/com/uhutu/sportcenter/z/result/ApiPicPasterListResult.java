package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.sportcenter.z.entity.PicPasterInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 贴纸列表
 * @author xiegj
 *
 */
@ApiModel
public class ApiPicPasterListResult extends RootApiResult {
	
	@ApiModelProperty(value="推荐标签列表")
	private List<PicPasterInfo> pti = new ArrayList<PicPasterInfo>();

	public List<PicPasterInfo> getPti() {
		return pti;
	}

	public void setPti(List<PicPasterInfo> pti) {
		this.pti = pti;
	}

}
