package com.uhutu.sportcenter.z;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiPublishContentPhotosInput;
import com.uhutu.sportcenter.z.result.ApiPublishContentPhotosResult;
import com.uhutu.zoocom.root.RootApiToken;

/**
 * 图集内容发布
 * 
 * @author pang_jhui
 *
 */
public class ApiPublishContentPhotos extends RootApiToken<ApiPublishContentPhotosInput, ApiPublishContentPhotosResult> {
	
	@Autowired
	private ContentServiceFactory serviceFactory;

	@Override
	protected ApiPublishContentPhotosResult process(ApiPublishContentPhotosInput input) {

		ApiPublishContentPhotosResult contentPhotosResult = new ApiPublishContentPhotosResult();

		if (input.getContentBasicInfo() != null && input.getContentPhotos() != null) {
			
			CnContentBasicinfo contentBasicinfo = new CnContentBasicinfo();
			
			BeanUtils.copyProperties(input.getContentBasicInfo(), contentBasicinfo);
			
			contentBasicinfo.setAuthor(input.getZoo().getToken());
			
			serviceFactory.getContentBasicinfoService().save(contentBasicinfo);
			

		} else {

		}

		return contentPhotosResult;
	}

}
