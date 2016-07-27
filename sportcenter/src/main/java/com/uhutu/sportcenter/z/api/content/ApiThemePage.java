package com.uhutu.sportcenter.z.api.content;

import org.springframework.stereotype.Service;

import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ThemePageModel;
import com.uhutu.sportcenter.z.input.ApiThemePageInput;
import com.uhutu.sportcenter.z.result.ApiThemePageResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 专题数据展示
 * 
 * @author xiegj
 */
@Service
public class ApiThemePage extends RootApiBase<ApiThemePageInput, ApiThemePageResult> {

	protected ApiThemePageResult process(ApiThemePageInput input) {
		ApiThemePageResult result = new ApiThemePageResult();
		ThemePageModel mm = new ThemePageModel();
		mm.getInfos().add(new ContentBasicinfoForApi());
		result.getModels().add(mm);

		return result;
	}
}
