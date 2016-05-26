package com.uhutu.sportcenter.z.api.content;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.z.result.ApiPublishSportingMomentResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 发布运动时刻
 * 
 * @author xiegj
 *
 */
@Service
public class ApiPublishSportingMoment
		extends RootApiToken<ApiPublishSportingMomentInput, ApiPublishSportingMomentResult> {

	@Autowired
	private ContentServiceFactory contentServiceFactory;

	protected ApiPublishSportingMomentResult process(ApiPublishSportingMomentInput input) {

		ApiPublishSportingMomentResult momentResult = new ApiPublishSportingMomentResult();

		CnContentBasicinfo contentBasicinfo = new CnContentBasicinfo();

		CnContentDetail contentDetail = new CnContentDetail();

		BeanUtils.copyProperties(input.getMoment(), contentBasicinfo);

		BeanUtils.copyProperties(input.getMomentDetailInfo(), contentDetail);

		contentBasicinfo.setAuthor(upUserCode());

		contentServiceFactory.getContentBasicinfoService().save(contentBasicinfo);

		contentDetail.setCode(contentBasicinfo.getCode());

		contentServiceFactory.getContentDetailService().save(contentDetail);

		return momentResult;
	}

}
