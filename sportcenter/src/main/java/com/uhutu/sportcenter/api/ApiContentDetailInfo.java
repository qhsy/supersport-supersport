package com.uhutu.sportcenter.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.ContentDetailServiceFactory;
import com.uhutu.sportcenter.api.entity.ContentDetailInfo;
import com.uhutu.sportcenter.api.input.ApiContentDetailInput;
import com.uhutu.sportcenter.api.result.ApiContentDetailResult;
import com.uhutu.zoocom.root.RootApiBase;
/**
 * 内容详情信息
 * @author pang_jhui
 *
 */
@Service
public class ApiContentDetailInfo extends RootApiBase<ApiContentDetailInput, ApiContentDetailResult> {

	@Autowired
	private ContentDetailServiceFactory detailServiceFactory;
	
	@Override
	protected ApiContentDetailResult process(ApiContentDetailInput input) {
		
		CnContentDetail cnContentDetail = detailServiceFactory.getContentDetailService().queryByCode(input.getContent_code());
		
		ContentDetailInfo contentDetailInfo = new ContentDetailInfo();
		
		BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);
		
		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();
		
		contentDetailResult.setContentDetailInfo(contentDetailInfo);
		
		return contentDetailResult;
		
	}

	

}
