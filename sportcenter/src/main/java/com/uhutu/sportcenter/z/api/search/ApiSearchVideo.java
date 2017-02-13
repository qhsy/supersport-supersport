package com.uhutu.sportcenter.z.api.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.pay.z.util.BeanComponent;
import com.uhutu.dcom.search.z.entity.ResponseData;
import com.uhutu.dcom.search.z.entity.VideoData;
import com.uhutu.dcom.search.z.service.SearchServiceFactory;
import com.uhutu.sportcenter.z.input.ApiSearchVideoInput;
import com.uhutu.sportcenter.z.result.ApiSearchVideoResult;
import com.uhutu.zoocom.helper.GsonHelper;
import com.uhutu.zoocom.model.MDataMap;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 搜索用户
 * @author 逄小帅
 *
 */
@Component
public class ApiSearchVideo extends RootApiBase<ApiSearchVideoInput, ApiSearchVideoResult> {

	@Override
	protected ApiSearchVideoResult process(ApiSearchVideoInput input) {
		
		ApiSearchVideoResult searchVideoResult = new ApiSearchVideoResult();
		
		int number = 10;
		
		int start = (input.getPagination() -1) * number;
		
		ResponseData responseData = SearchServiceFactory.getInstance().getSearchUserService().search(input.getTitle(), start, number);
		
		if(StringUtils.equals(responseData.getStatus(), "OK")){
			
			try {
				
				if(responseData.getResult() != null && responseData.getResult().getItems() != null){
					
					for ( MDataMap item : responseData.getResult().getItems()) {
						
						VideoData videoData = BeanComponent.getInstance().invoke(VideoData.class, item, false);
						
						if(videoData != null && StringUtils.isNotEmpty(videoData.getCover())){
							
							String coverUrl = ImageHelper.upImageThumbnail(videoData.getCover(), input.getWidth());
							
							videoData.setCover(coverUrl);
							
						}
						
						searchVideoResult.getVideoDatas().add(videoData);
						
					}
					
					int total = start + number;
					
					if(total < responseData.getResult().getViewtotal()){
						
						searchVideoResult.setNextPageFlag(true);
						
					}
					
				}
				
			} catch (Exception e) {
				
				searchVideoResult.setStatus(-2);
				
				searchVideoResult.setError("数据转换时出现问题");
				
			}
			
		}else{
			
			searchVideoResult.setStatus(-1);
			
			if(responseData.getErrors()!= null && !responseData.getStatus().isEmpty()){
				
				searchVideoResult.setError(GsonHelper.toJson(responseData.getErrors()));
				
			}else{
				
				searchVideoResult.setError("数据查询出现问题");
				
			}
			
		}
		
		return searchVideoResult;
	}

}
