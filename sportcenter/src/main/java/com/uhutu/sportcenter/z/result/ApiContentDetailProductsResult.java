package com.uhutu.sportcenter.z.result;

import java.util.ArrayList;
import java.util.List;

import com.uhutu.dcom.content.z.entity.PcProductInfo;
import com.uhutu.zoocom.root.RootApiResult;

import io.swagger.annotations.ApiModelProperty;

public class ApiContentDetailProductsResult extends RootApiResult {

	@ApiModelProperty(value = "文章信息", notes = "文章信息")
	private List<PcProductInfo> productInfos = new ArrayList<PcProductInfo>();

	public List<PcProductInfo> getProductInfos() {
		return productInfos;
	}

	public void setProductInfos(List<PcProductInfo> productInfos) {
		this.productInfos = productInfos;
	}

}
