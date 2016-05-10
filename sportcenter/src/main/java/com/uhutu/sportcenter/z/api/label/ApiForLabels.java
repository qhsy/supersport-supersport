package com.uhutu.sportcenter.z.api.label;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.dcom.tag.z.service.ContentLabelServiceFactory;
import com.uhutu.dcom.tag.z.service.IContentLabelService;
import com.uhutu.sportcenter.z.entity.Label;
import com.uhutu.sportcenter.z.input.ApiForLabelsInput;
import com.uhutu.sportcenter.z.result.ApiForLabelsResult;
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
				BeanUtils.copyProperties(contentLabels.get(i), label);
				labels.add(label);
			}
		}
		result.setLabels(labels);
		return result;
	}

}
