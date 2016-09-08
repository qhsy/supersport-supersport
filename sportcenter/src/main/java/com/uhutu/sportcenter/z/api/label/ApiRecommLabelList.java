package com.uhutu.sportcenter.z.api.label;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.tag.z.entity.CnContentLabel;
import com.uhutu.dcom.tag.z.entity.CnLabelRecomm;
import com.uhutu.sportcenter.z.entity.Label;
import com.uhutu.sportcenter.z.input.ApiRecommLabelListInput;
import com.uhutu.sportcenter.z.result.ApiRecommLableListResult;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zoodata.z.helper.JdbcHelper;

/**
 * 推荐标签
 * @author 逄小帅
 *
 */
@Component
public class ApiRecommLabelList extends RootApiBase<ApiRecommLabelListInput, ApiRecommLableListResult> {

	@Override
	protected ApiRecommLableListResult process(ApiRecommLabelListInput input) {
		
		ApiRecommLableListResult result = new ApiRecommLableListResult();
		
		List<CnLabelRecomm> recommLabels = getLabelRecommList();
		
		if(recommLabels != null){
			
			for (CnLabelRecomm cnLabelRecomm : recommLabels) {
				
				CnContentLabel contentLabel = JdbcHelper.queryOne(CnContentLabel.class, "code",cnLabelRecomm.getTagCode());
				
				Label label = new Label();
				
				BeanUtils.copyProperties(contentLabel, label);
				
				result.getLabels().add(label);
				
			}
			
		}
		
		return result;
	}
	
	public List<CnLabelRecomm> getLabelRecommList(){
		
		MDataMap mWhereMap = new MDataMap();
		
		mWhereMap.put("type", "dzsd4124100110020001");
		
		return JdbcHelper.queryForList(CnLabelRecomm.class, "", "-sort", "", mWhereMap);
		
	}

}
