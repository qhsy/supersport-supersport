package com.uhutu.sportcenter.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uhutu.dcom.content.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.ContentServiceFactory;
import com.uhutu.sportcenter.api.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.api.result.ApiPublishSportingMomentResult;
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
		
		contentBasicinfo.setAuthor(input.getZoo().getToken());
		
		contentServiceFactory.getContentBasicinfoService().save(contentBasicinfo);
		
		contentDetail.setCode(contentBasicinfo.getCode());
		
		contentServiceFactory.getContentDetailService().save(contentDetail);
		
		return momentResult;
	}

}
