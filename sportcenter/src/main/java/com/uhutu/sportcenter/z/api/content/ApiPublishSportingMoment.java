package com.uhutu.sportcenter.z.api.content;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uhutu.dcom.content.z.entity.CnContentBasicinfo;
import com.uhutu.dcom.content.z.entity.CnContentDetail;
import com.uhutu.dcom.content.z.service.ContentServiceFactory;
import com.uhutu.sportcenter.z.input.ApiPublishSportingMomentInput;
import com.uhutu.sportcenter.z.result.ApiPublishSportingMomentResult;
import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.root.RootApiToken;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zooweb.support.WebUploadSupport;

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

		if (StringUtils.isNoneBlank(contentBasicinfo.getCover())
				&& StringUtils.isNotBlank(contentBasicinfo.getTagCode())
				&& contentBasicinfo.getTagCode().contains("GGBH160719110001")) {// 翘臀大赛加水印
			String waterMarker = getWaterMarker(contentBasicinfo.getCover());
			contentBasicinfo.setCover(StringUtils.isNotBlank(waterMarker) ? waterMarker : contentBasicinfo.getCover());
		}
		contentServiceFactory.getContentBasicinfoService().save(contentBasicinfo);

		contentDetail.setCode(contentBasicinfo.getCode());

		contentServiceFactory.getContentDetailService().save(contentDetail);

		return momentResult;
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 */
	private String getWaterMarker(String url) {
		String result = "";
		OutputStream os = null;
		try {
			HttpEntity httpEntity = WebClientSupport.create().upEntity(url);
			InputStream buffin = httpEntity.getContent();
			Image srcImg = ImageIO.read(buffin);
			BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null),
					BufferedImage.TYPE_INT_RGB);
			// 得到画笔对象
			Graphics2D g = buffImg.createGraphics();
			// 设置对线段的锯齿状边缘处理
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0,
					0, null);
			// 得到Image对象。
			Image img = ImageIO.read(WebClientSupport.create()
					.upEntity(
							"http://img-cdn.bigtiyu.com/wsc/sport/273cf/s-558-224/b024fff5c8ba4fdbb89874fbfce4a2a1.png")
					.getContent());
			float alpha = 1.0f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			g.drawImage(img, srcImg.getWidth(null) - 608, 30, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();// 新建流。
			ImageIO.write(buffImg, StringUtils.substringAfterLast(url, ".").toUpperCase(), bos);// 利用ImageIO类提供的write方法，将bi以png图片的数据模式写入流。
			byte b[] = bos.toByteArray();// 从流中获取数据数组。
			FileUploadResult webUploadResult = new WebUploadSupport().remoteUpload("buttock",
					TopHelper.upUuid() + "." + StringUtils.substringAfterLast(url, "."), b);
			if (webUploadResult.upFlagTrue()) {
				result = webUploadResult.getFileUrl();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != os)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
