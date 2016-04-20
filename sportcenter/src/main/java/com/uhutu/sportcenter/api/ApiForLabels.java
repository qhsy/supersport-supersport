package com.uhutu.sportcenter.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.tag.entity.CnContentLabel;
import com.uhutu.dcom.tag.service.ContentLabelServiceFactory;
import com.uhutu.dcom.tag.service.IContentLabelService;
import com.uhutu.sportcenter.api.entity.Label;
import com.uhutu.sportcenter.api.input.ApiForLabelsInput;
import com.uhutu.sportcenter.api.result.ApiForLabelsResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 运动标签
 * 
 * @author xiegj
 */
@Service
public class ApiForLabels extends RootApiToken<ApiForLabelsInput, ApiForLabelsResult> {

	@Autowired
	private ContentLabelServiceFactory contentLabelServiceFactory;

	protected ApiForLabelsResult process(ApiForLabelsInput input) {
		ApiForLabelsResult result = new ApiForLabelsResult();

		IContentLabelService service = contentLabelServiceFactory.getContentLabelService();

		List<CnContentLabel> contentLabels = service.queryAll();

		List<Label> labels = new ArrayList<Label>();
		if (contentLabels != null && !contentLabels.isEmpty() && contentLabels.size() > 0) {
			for (int i = 0; i < contentLabels.size(); i++) {
				Label label = new Label();
				BeanUtils.copyProperties(contentLabels.get(0), label);
				labels.add(label);
			}
		}
		result.setLabels(labels);
		return result;
	}

}
