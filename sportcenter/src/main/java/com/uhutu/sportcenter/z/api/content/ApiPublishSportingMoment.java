package com.uhutu.sportcenter.z.api.content;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.component.z.util.EmojiUtil;
import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.content.z.support.WaterMarkerSupport;
import com.uhutu.sportcenter.z.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.z.result.ApiPublishSportingMomentResult;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.io.ImageThumb;

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

		String title = contentBasicinfo.getTitle();

		title = StringUtils.isEmpty(title) ? "" : EmojiUtil.emojiFilter(title);

		contentBasicinfo.setTitle(title);

//		String content = contentDetail.getContent();
//
//		content = StringUtils.isEmpty(content) ? "" : EmojiUtil.emojiFilter(content);
//
//		contentDetail.setContent(content);
//
//		contentBasicinfo.setAuthor(upUserCode());
//
//		String waterMarker = new WaterMarkerSupport().getWaterMarker(contentBasicinfo.getCover(),
//				contentBasicinfo.getTagCode());// 背景图加水印
//		contentBasicinfo.setCover(StringUtils.isNotBlank(waterMarker) ? waterMarker : contentBasicinfo.getCover());
//		if (StringUtils.isNotBlank(contentBasicinfo.getCover())) {
//			ImageThumb thumb = ImageHelper.upThumbWithHeight(contentBasicinfo.getCover(), 640);
//			if (thumb != null) {
//				contentBasicinfo.setCoverWH(thumb.getSourceWidth() + "*" + thumb.getSourceHeight());
//			}
//		}
		contentServiceFactory.getContentBasicinfoService().save(contentBasicinfo);

		contentDetail.setCode(contentBasicinfo.getCode());

		contentServiceFactory.getContentDetailService().save(contentDetail);
		momentResult.setCode(contentBasicinfo.getCode());
		return momentResult;
	}

}
