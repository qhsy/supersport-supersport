package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentPhotos;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.content.z.support.WaterMarkerSupport;
import com.uhutu.sportcenter.z.entity.ContentPhotosDetail;
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
			if (StringUtils.isNotBlank(contentBasicinfo.getCover())
					&& StringUtils.isNotBlank(contentBasicinfo.getTagCode())
					&& contentBasicinfo.getTagCode().contains("GGBH160719110001")) {// 翘臀大赛加水印
				String waterMarker = new WaterMarkerSupport().getWaterMarker(contentBasicinfo.getCover());
				contentBasicinfo
						.setCover(StringUtils.isNotBlank(waterMarker) ? waterMarker : contentBasicinfo.getCover());
			}
			serviceFactory.getContentBasicinfoService().save(contentBasicinfo);

			int sort = 0;

			List<CnContentPhotos> cnContentPhotos = new ArrayList<CnContentPhotos>();

			for (ContentPhotosDetail entity : input.getContentPhotos()) {

				sort++;

				CnContentPhotos temp = new CnContentPhotos();

				BeanUtils.copyProperties(entity, temp);

				temp.setContentCode(contentBasicinfo.getCode());

				temp.setZc(new Date());

				temp.setSort(sort);

				cnContentPhotos.add(temp);

			}

			serviceFactory.getContentPhotosService().save(cnContentPhotos);

		} else {

			contentPhotosResult.setStatus(0);

			contentPhotosResult.setError("内容信息不存在");

		}

		return contentPhotosResult;
	}

}
