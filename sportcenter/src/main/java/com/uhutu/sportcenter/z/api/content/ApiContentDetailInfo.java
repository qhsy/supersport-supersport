package com.uhutu.sportcenter.z.api.content;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentBasicinfoServiceFactory;
import com.uhutu.dcom.content.z.service.ContentDetailServiceFactory;
import com.uhutu.dcom.user.z.entity.UcUserinfoExt;
import com.uhutu.dcom.user.z.service.UserServiceFactory;
import com.uhutu.sportcenter.z.entity.ContentBasicinfoForApi;
import com.uhutu.sportcenter.z.entity.ContentDetailInfo;
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

		UcUserinfoExt ucUserinfoExt = userServiceFactory.getUserInfoExtService()
				.queryByUserCode(contentBasicinfoForApi.getAuthor());

		contentBasicinfoForApi.setAboutHead(ucUserinfoExt.getAboutHead());

		contentBasicinfoForApi.setNickName(ucUserinfoExt.getNickName());

		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();

		contentDetailResult.setContentDetailInfo(contentDetailInfo);

		contentDetailResult.setSportingMoment(contentBasicinfoForApi);

		return contentDetailResult;

	}

}
