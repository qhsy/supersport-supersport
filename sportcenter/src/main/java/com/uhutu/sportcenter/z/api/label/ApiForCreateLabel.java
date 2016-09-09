package com.uhutu.sportcenter.z.api.label;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.sportcenter.z.input.ApiForCreateLabelInput;
import com.uhutu.sportcenter.z.result.ApiForCreateLabelResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;
import com.uhutu.zooweb.helper.WebHelper;

/**
 * 用户新增标签
 * 
 * @author xiegj
 */
@Service
public class ApiForCreateLabel extends RootApiToken<ApiForCreateLabelInput, ApiForCreateLabelResult> {

	protected ApiForCreateLabelResult process(ApiForCreateLabelInput input) {
		ApiForCreateLabelResult result = new ApiForCreateLabelResult();
		CnContentLabel contentLabel = new CnContentLabel();
		contentLabel = JdbcHelper.queryOne(CnContentLabel.class, "name", input.getName(),"labelType","dzsd4124100110010002");
		if (contentLabel == null) {
			contentLabel = new CnContentLabel();
			contentLabel.setCode(WebHelper.upCode("GGBH"));
			contentLabel.setStatus("dzsd4699100110010001");
			contentLabel.setLabelType("dzsd4124100110010002");
			contentLabel.setContent("");
			contentLabel.setCover("");
			contentLabel.setName(input.getName());
			contentLabel.setSort(0);
			contentLabel.setType(upUserCode());
			JdbcHelper.insert(contentLabel);
		}
		BeanUtils.copyProperties(contentLabel, result.getLabel());
		return result;
	}

}
