package com.uhutu.sportcenter.z.api.content;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.dcom.content.z.support.WaterMarkerSupport;
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

		String waterMarker = new WaterMarkerSupport().getWaterMarker(contentBasicinfo.getCover(),
				contentBasicinfo.getTagCode());// 背景图加水印
		contentBasicinfo.setCover(StringUtils.isNotBlank(waterMarker) ? waterMarker : contentBasicinfo.getCover());
		if (StringUtils.isNotBlank(contentBasicinfo.getCover())) {
			String wh = getBufferedImage(contentBasicinfo.getCover());
			if (StringUtils.isNotBlank(wh)) {
				contentBasicinfo.setCoverWH(wh);
			}
		}
		contentServiceFactory.getContentBasicinfoService().save(contentBasicinfo);

		contentDetail.setCode(contentBasicinfo.getCode());

		contentServiceFactory.getContentDetailService().save(contentDetail);

		return momentResult;
	}

	/**
	 * 
	 * @param imgUrl
	 *            图片地址
	 * @return
	 */
	public static String getBufferedImage(String imgUrl) {
		URL url = null;
		InputStream is = null;
		String result = null;
		try {
			url = new URL(imgUrl);
			is = url.openStream();
			BufferedImage img = ImageIO.read(is);
			if (img != null) {
				result = img.getWidth() + "*" + img.getHeight();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
