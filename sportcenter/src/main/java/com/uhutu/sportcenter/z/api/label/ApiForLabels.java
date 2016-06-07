package com.uhutu.sportcenter.z.api.label;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.sportcenter.z.entity.Label;
import com.uhutu.sportcenter.z.input.ApiForLabelsInput;
import com.uhutu.sportcenter.z.result.ApiForLabelsResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 运动标签
 * 
 * @author xiegj
 */
@Service
public class ApiForLabels extends RootApiToken<ApiForLabelsInput, ApiForLabelsResult> {

	protected ApiForLabelsResult process(ApiForLabelsInput input) {
		ApiForLabelsResult result = new ApiForLabelsResult();

		MDataMap map = new MDataMap();
		map.put("status", "dzsd4699100110010001");
		map.put("labelType", "dzsd4124100110010002");
		List<CnContentLabel> contentLabels = JdbcHelper.queryForList(CnContentLabel.class, "", "-sort",
				"status=:status and labelType=:labelType", map);

		List<Label> labels = new ArrayList<Label>();
		if (contentLabels != null && !contentLabels.isEmpty() && contentLabels.size() > 0) {
			for (int i = 0; i < contentLabels.size(); i++) {
				Label label = new Label();
				BeanUtils.copyProperties(contentLabels.get(i), label);
				labels.add(label);
			}
		}
		result.setLabels(labels);
		return result;
	}

}
