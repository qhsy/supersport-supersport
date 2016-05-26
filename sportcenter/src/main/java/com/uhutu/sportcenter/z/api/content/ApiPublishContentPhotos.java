package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;
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
@Component
public class ApiPublishContentPhotos extends RootApiToken<ApiPublishContentPhotosInput, ApiPublishContentPhotosResult> {
	
	@Autowired
	private ContentServiceFactory serviceFactory;

	@Override
	protected ApiPublishContentPhotosResult process(ApiPublishContentPhotosInput input) {

		ApiPublishContentPhotosResult contentPhotosResult = new ApiPublishContentPhotosResult();

		if (input.getContentBasicInfo() != null && input.getContentPhotos() != null) {
			
			CnContentBasicinfo contentBasicinfo = new CnContentBasicinfo();
			
			BeanUtils.copyProperties(input.getContentBasicInfo(), contentBasicinfo);
			
			contentBasicinfo.setAuthor(upUserCode());
			
			serviceFactory.getContentBasicinfoService().save(contentBasicinfo);
			
			List<CnContentPhotos> cnContentPhotos = new ArrayList<CnContentPhotos>();
			
			input.getContentPhotos().forEach(entity -> {
				
				CnContentPhotos temp = new CnContentPhotos();
				
				BeanUtils.copyProperties(entity, temp);
				
				temp.setContentCode(contentBasicinfo.getCode());
				
				temp.setZc(new Date());
				
				cnContentPhotos.add(temp);
				
			});
			
			serviceFactory.getContentPhotosService().save(cnContentPhotos);
			

		} else {
			
			contentPhotosResult.setStatus(0);
			
			contentPhotosResult.setError("内容信息不存在");
			

		}

		return contentPhotosResult;
	}

}
