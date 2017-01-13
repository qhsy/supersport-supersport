package com.uhutu.sportcenter.z.api.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.search.z.entity.MatchData;
import com.uhutu.dcom.search.z.entity.ResponseData;
import com.uhutu.dcom.search.z.service.SearchServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSearchMatchInput;
import com.uhutu.sportcenter.z.result.ApiSearchMatchResult;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 搜索用户
 * @author 逄小帅
 *
 */
@Component
public class ApiSearchMatch extends RootApiBase<ApiSearchMatchInput, ApiSearchMatchResult> {

	@Override
	protected ApiSearchMatchResult process(ApiSearchMatchInput input) {
		
		ApiSearchMatchResult searchMatchResult = new ApiSearchMatchResult();
		
		int number = 10;
		
		int start = (input.getPagination() -1) * number;
		
		ResponseData responseData = SearchServiceFactory.getInstance().getSearchMatchService().search(input.getTitle(), start, number);
		
		if(StringUtils.equals(responseData.getStatus(), "OK")){
			
			try {
				
				if(responseData.getResult() != null && responseData.getResult().getItems() != null){
					
					for ( MDataMap item : responseData.getResult().getItems()) {
						
						MatchData matchData = BeanComponent.getInstance().invoke(MatchData.class, item, false);
						
						searchMatchResult.getMatchDatas().add(matchData);
					}
					
					int total = start + number;
					
					if(total < responseData.getResult().getViewtotal()){
						
						searchMatchResult.setNextPageFlag(true);
						
					}
					
				}
				
			} catch (Exception e) {
				
				searchMatchResult.setStatus(-2);
				
				searchMatchResult.setError("数据转换时出现问题");
				
			}
			
		}else{
			
			searchMatchResult.setStatus(-1);
			
			if(responseData.getErrors()!= null && !responseData.getStatus().isEmpty()){
				
				searchMatchResult.setError(GsonHelper.toJson(responseData.getErrors()));
				
			}else{
				
				searchMatchResult.setError("数据查询出现问题");
				
			}
			
		}
		
		return searchMatchResult;
	}

}
