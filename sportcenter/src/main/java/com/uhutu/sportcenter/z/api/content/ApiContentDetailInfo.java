package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.entity.CnContentRecomm;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentDetailInfo;
import com.uhutu.sportcenter.z.entity.ContentRecommInfo;
import com.uhutu.sportcenter.z.input.ApiContentDetailInput;
import com.uhutu.sportcenter.z.result.ApiContentDetailResult;
import com.uhutu.zoocom.root.RootApiBase;

/**
 * 内容详情信息
 * 
 * @author pang_jhui
 *
 */
@Service
public class ApiContentDetailInfo extends RootApiBase<ApiContentDetailInput, ApiContentDetailResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiContentDetailResult process(ApiContentDetailInput input) {
		
		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();

		if(StringUtils.isNotBlank(input.getContent_code())){
			
			CnContentDetail cnContentDetail = contentServiceFactory.getContentDetailService()
					.queryByCode(input.getContent_code());

			ContentBasicinfoForApi contentBasicinfoForApi = new ContentBasicinfoForApi();

			CnContentBasicinfo cnContentBasicinfo = contentServiceFactory.getContentBasicinfoService()
					.queryByCode(input.getContent_code());

			ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

			if(cnContentDetail != null){
				
				BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);

				BeanUtils.copyProperties(cnContentBasicinfo, contentBasicinfoForApi);

				UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
						.queryByUserCode(contentBasicinfoForApi.getAuthor());

				contentBasicinfoForApi.setAboutHead(ucUserinfoExt.getAboutHead());

				contentBasicinfoForApi.setNickName(ucUserinfoExt.getNickName());		
				
				ContentRecommInfo recommInfo = new ContentRecommInfo();
				
				CnContentRecomm sourceRecommInfo = contentServiceFactory.getContentRecommService().queryEntityByCode(input.getContent_code());
				
				if(sourceRecommInfo != null){
					
					BeanUtils.copyProperties(sourceRecommInfo, recommInfo);
					
					contentDetailResult.setContentRecommInfo(recommInfo);
					
				}
				
				contentDetailResult.setContentDetailInfo(contentDetailInfo);

				contentDetailResult.setSportingMoment(contentBasicinfoForApi);
				
			}else{
				
				contentDetailResult.setStatus(0);
				
				contentDetailResult.setError("内容详情不存在");
				
			}
			
		}

		return contentDetailResult;

	}

}
