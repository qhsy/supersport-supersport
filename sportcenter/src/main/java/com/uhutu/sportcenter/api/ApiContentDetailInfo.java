package com.uhutu.sportcenter.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.entity.CnContentDetail;
import com.uhutu.dcom.content.service.ContentDetailServiceFactory;
import com.uhutu.sportcenter.api.entity.ContentBasicinfoForApi;
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
		
		ContentBasicinfoForApi contentBasicinfoForApi = new ContentBasicinfoForApi();
		
		contentBasicinfoForApi.setAboutHead("http://photocdn.sohu.com/20160422/Img445491965.jpg");
		
		contentBasicinfoForApi.setCover("http://bigsport.oss-cn-beijing.aliyuncs.com/%E7%AF%AE%E7%90%83%E8%BF%90%E5%8A%A8%E7%BB%93%E6%9D%9F%E5%90%8E%E7%9A%84%E9%9D%99%E6%80%81%E6%8B%89%E4%BC%B8%E5%8A%A8%E4%BD%9C.jpg");
		
		contentBasicinfoForApi.setTitle("篮球运动结束后的静态拉伸动作");
		
		contentBasicinfoForApi.setTagCode("篮球");
		
		contentBasicinfoForApi.setAuthor("pangjhCode");
		
		contentBasicinfoForApi.setLocaltionName("北京水立方游泳中心");
		
		ContentDetailInfo contentDetailInfo = new ContentDetailInfo();
		
		BeanUtils.copyProperties(cnContentDetail, contentDetailInfo);
		
		ApiContentDetailResult contentDetailResult = new ApiContentDetailResult();
		
		contentDetailResult.setContentDetailInfo(contentDetailInfo);
		
		contentDetailResult.setSportingMoment(contentBasicinfoForApi);
		
		return contentDetailResult;
		
	}

	

}
