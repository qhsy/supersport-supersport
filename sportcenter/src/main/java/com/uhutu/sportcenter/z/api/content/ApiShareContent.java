package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiShareContentInput;
import com.uhutu.sportcenter.z.result.ApiShareContentResult;
import com.uhutu.zoocom.root.RootApiBase;
import com.uhutu.zooweb.helper.ImageHelper;

/**
 * 分享内容
 * @author 逄小帅
 *
 */
public class ApiShareContent extends RootApiBase<ApiShareContentInput, ApiShareContentResult> {
	
	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Override
	protected ApiShareContentResult process(ApiShareContentInput input) {
		
		ApiShareContentResult shareResult = new ApiShareContentResult();
		
		CnContentBasicinfo basicInfo = contentServiceFactory.getContentBasicinfoService().queryByCode(input.getContentCode());
		
		CnContentDetail detailInfo = contentServiceFactory.getContentDetailService().queryByCode(input.getContentCode());
		
		if(basicInfo != null){
			
			shareResult.setTitle(basicInfo.getTitle());
			
			if(StringUtils.isNotEmpty(basicInfo.getCover())){
				
				shareResult.setIconUrl(ImageHelper.upImageThumbnail(basicInfo.getCover(), 120));
				
				if(detailInfo != null){
					
					if(StringUtils.isNotBlank(detailInfo.getContent())){
						
						String content = StringUtils.substring(detailInfo.getContent(), 0, 20);
						
						shareResult.setContent(content);
						
					}else{
						
						shareResult.setContent(basicInfo.getTitle());
						
					}
					
				}else{
					
					shareResult.setContent(basicInfo.getTitle());
					
				}
				
			}
			
		}else{
			
			shareResult.inError(810710008);
			
		}
		
		return shareResult;
	}

}
