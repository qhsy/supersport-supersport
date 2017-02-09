package com.uhutu.sportcenter.z.api.search;

import java.util.List;

import org.springframework.stereotype.Component;

import com.uhutu.dcom.search.z.entity.SeKeyWordRecomm;
import com.uhutu.sportcenter.z.input.ApiKeyWordRecommInput;
import com.uhutu.sportcenter.z.result.ApiKeyWordRecommResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 搜索推荐
 * 
 * @author xiegj
 *
 */
@Component
public class ApiKeyWordRecomm extends RootApiBase<ApiKeyWordRecommInput, ApiKeyWordRecommResult> {

	@Override
	protected ApiKeyWordRecommResult process(ApiKeyWordRecommInput input) {

		ApiKeyWordRecommResult result = new ApiKeyWordRecommResult();

		List<SeKeyWordRecomm> li = JdbcHelper.queryForList(SeKeyWordRecomm.class, "code,title,sort", "-sort", "", null);
		if (li != null && li.size() > 0) {
			result.setLabels(li);
		}
		return result;
	}

}
