package com.uhutu.sportcenter.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.content.service.ContentDetailServiceFactory;
import com.uhutu.dcom.user.entity.UcUserinfoExt;
import com.uhutu.dcom.user.service.UserServiceFactory;
import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.api.entity.ContentDetailInfo;
import com.uhutu.sportcenter.api.input.ApiContentDetailInput;
import com.uhutu.sportcenter.api.result.ApiContentDetailResult;
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
	private ContentDetailServiceFactory detailServiceFactory;

	@Autowired
	private ContentBasicinfoServiceFactory basicInfoServiceFactory;
	
	@Autowired
	private UserServiceFactory userServiceFactory;

	@Override
	protected ApiContentDetailResult process(ApiContentDetailInput input) {

		CnContentDetail cnContentDetail = detailServiceFactory.getContentDetailService()
				.queryByCode(input.getContent_code());

		ContentBasicinfoForApi contentBasicinfoForApi = new ContentBasicinfoForApi();

		CnContentBasicinfo cnContentBasicinfo = basicInfoServiceFactory.getContentBasicinfoService()
				.queryByCode(input.getContent_code());

		ContentDetailInfo contentDetailInfo = new ContentDetailInfo();

		BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);
		
		BeanUtils.copyProperties(cnContentBasicinfo, contentBasicinfoForApi);
		
		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService().queryByUserCode(contentBasicinfoForApi.getAuthor());
		
		contentBasicinfoForApi.setAboutHead(ucUserinfoExt.getAboutHead());
		
		contentBasicinfoForApi.setNickName(ucUserinfoExt.getNickName());

		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();

		contentDetailResult.setContentDetailInfo(contentDetailInfo);

		contentDetailResult.setSportingMoment(contentBasicinfoForApi);

		return contentDetailResult;

	}

}
