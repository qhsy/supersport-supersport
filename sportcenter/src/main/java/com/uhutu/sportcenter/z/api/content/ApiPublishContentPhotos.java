package com.uhutu.sportcenter.z.api.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uhutu.dcom.component.z.util.EmojiUtil;
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
		String code = "";
		if (input.getContentBasicInfo() != null && input.getContentPhotos() != null) {

			CnContentBasicinfo contentBasicinfo = new CnContentBasicinfo();

			BeanUtils.copyProperties(input.getContentBasicInfo(), contentBasicinfo);
			contentBasicinfo.setAuthor(upUserCode());
//			String waterMarker = new WaterMarkerSupport().getWaterMarker(contentBasicinfo.getCover(),
//					contentBasicinfo.getTagCode());// 背景图加水印
//			contentBasicinfo.setCover(StringUtils.isNotBlank(waterMarker) ? waterMarker : contentBasicinfo.getCover());
			
			String title = contentBasicinfo.getTitle();
					
			title = StringUtils.isEmpty(title)? "" : EmojiUtil.emojiFilter(title);
			
			contentBasicinfo.setTitle(title);
			
			serviceFactory.getContentBasicinfoService().save(contentBasicinfo);
			
			code = contentBasicinfo.getCode();

			int sort = 0;

			List<CnContentPhotos> cnContentPhotos = new ArrayList<CnContentPhotos>();

			for (ContentPhotosDetail entity : input.getContentPhotos()) {

				sort++;

				CnContentPhotos temp = new CnContentPhotos();

				BeanUtils.copyProperties(entity, temp);

				temp.setContentCode(contentBasicinfo.getCode());
				
				String content = temp.getContent();
						
				content = StringUtils.isEmpty(content)? "" : EmojiUtil.emojiFilter(content);
				
				temp.setContent(content);

				temp.setZc(new Date());

				temp.setSort(sort);

				cnContentPhotos.add(temp);

			}

			serviceFactory.getContentPhotosService().save(cnContentPhotos);

		} else {

			contentPhotosResult.setStatus(0);

			contentPhotosResult.setError("内容信息不存在");

		}

		if (contentPhotosResult.upFlagTrue()) {

			contentPhotosResult.setCode(code);

		}

		return contentPhotosResult;
	}

}
