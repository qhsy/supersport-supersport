package com.uhutu.sportcenter.z.api.content;

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

		CnContentDetail cnContentDetail = contentServiceFactory.getContentDetailService()
				.queryByCode(input.getContent_code());

		ContentBasicinfoForApi contentBasicinfoForApi = new ContentBasicinfoForApi();

		CnContentBasicinfo cnContentBasicinfo = contentServiceFactory.getContentBasicinfoService()
				.queryByCode(input.getContent_code());

		ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

		BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);

		BeanUtils.copyProperties(cnContentBasicinfo, contentBasicinfoForApi);

		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
				.queryByUserCode(contentBasicinfoForApi.getAuthor());

		contentBasicinfoForApi.setAboutHead(ucUserinfoExt.getAboutHead());

		contentBasicinfoForApi.setNickName(ucUserinfoExt.getNickName());

		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();
		
		ContentRecommInfo recommInfo = new ContentRecommInfo();
		
		CnContentRecomm sourceRecommInfo = contentServiceFactory.getContentRecommService().queryEntityByCode(input.getContent_code());
		
		BeanUtils.copyProperties(sourceRecommInfo, recommInfo);

		contentDetailResult.setContentDetailInfo(contentDetailInfo);

		contentDetailResult.setSportingMoment(contentBasicinfoForApi);
		
		contentDetailResult.setContentRecommInfo(recommInfo);

		return contentDetailResult;

	}

}
