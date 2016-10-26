package com.uhutu.dcom.content.z.support;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;

import com.uhutu.zoocom.file.FileUploadResult;
import com.uhutu.zoocom.helper.TopHelper;
import com.uhutu.zoocom.support.WebClientSupport;
import com.uhutu.zooweb.helper.ImageHelper;
import com.uhutu.zooweb.support.WebUploadSupport;

public class WaterMarkerSupport {

	/**
	 * cross水印优先 为翘而生水印慢慢会弃用
	 */
	public String getWaterMarker(String picUrl, String tagCode) {
		String result = picUrl;
		// if (StringUtils.isNotBlank(tagCode) &&
		// StringUtils.isNotBlank(picUrl)) {
		// if (tagCode.contains("GGBH160823110001")) {// cross
		// result = this.getCrossFitWaterMarker(picUrl);
		// } else if (tagCode.contains("GGBH160719110001")) {// 为翘而生
		// result = this.getWqes(picUrl);
		// } else if (tagCode.contains("GGBH161011110001")) {// 昆赛搏击
		// result = this.getKSBJWaterMarker(picUrl);
		// } else if (tagCode.contains("GGBH161020110001") ||
		// tagCode.contains("GGBH161020210001")
		// || tagCode.contains("GGBH161020210002") ||
		// tagCode.contains("GGBH161020210003")) {//games
		// result = this.getGODOGamesWaterMarker(picUrl);
		// }
		// }

		return result;
	}

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 */
	private String getWqes(String url) {
		String result = "";
		OutputStream os = null;
		String waterPic = "http://img-cdn.bigtiyu.com/wsc/sport/273cf/s-558-224/b024fff5c8ba4fdbb89874fbfce4a2a1.png";
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
			// 根据1080原图等比压缩水印图大小及边距
			double prop = Double.valueOf(srcImg.getWidth(null)) / Double.valueOf(1080);
			waterPic = ImageHelper.upImageThumbnail(waterPic, (int) (prop * 558));
			// 得到水印Image对象。
			Image img = ImageIO.read(WebClientSupport.create().upEntity(waterPic).getContent());
			float alpha = 1.0f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			int width = (int) (prop * 608);
			int high = (int) (prop * 30);
			g.drawImage(img, srcImg.getWidth(null) - width, high, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(buffImg, StringUtils.substringAfterLast(url, ".").toUpperCase(), bos);
			byte b[] = bos.toByteArray();
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

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 */
	private String getCrossFitWaterMarker(String url) {
		String result = "";
		OutputStream os = null;
		String waterPic = "http://img-cdn.bigtiyu.com/wsc/sport/27437/s-186-52/73cd609f34914651a6215a28ffb402fd.png";
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
			// 根据1080原图等比压缩水印图大小及边距
			double prop = Double.valueOf(srcImg.getWidth(null)) / Double.valueOf(1080);
			waterPic = ImageHelper.upImageThumbnail(waterPic, (int) (prop * 186));
			// 得到水印Image对象。
			Image img = ImageIO.read(WebClientSupport.create().upEntity(waterPic).getContent());
			float alpha = 1.0f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			int width = (int) (prop * 196);
			int high = (int) (prop * 52);
			g.drawImage(img, srcImg.getWidth(null) - width, srcImg.getHeight(null) - high - 10, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(buffImg, StringUtils.substringAfterLast(url, ".").toUpperCase(), bos);
			byte b[] = bos.toByteArray();
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

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 */
	private String getKSBJWaterMarker(String url) {
		String result = "";
		OutputStream os = null;
		String waterPic = "http://img-cdn.bigtiyu.com/wsc/sport/274f3/s-186-52/4d9b04fff18449de936f124d30cafcf1.png";
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
			// 根据1080原图等比压缩水印图大小及边距
			double prop = Double.valueOf(srcImg.getWidth(null)) / Double.valueOf(1080);
			waterPic = ImageHelper.upImageThumbnail(waterPic, (int) (prop * 186));
			// 得到水印Image对象。
			Image img = ImageIO.read(WebClientSupport.create().upEntity(waterPic).getContent());
			float alpha = 1.0f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			int width = (int) (prop * 196);
			int high = (int) (prop * 52);
			g.drawImage(img, srcImg.getWidth(null) - width, srcImg.getHeight(null) - high - 10, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(buffImg, StringUtils.substringAfterLast(url, ".").toUpperCase(), bos);
			byte b[] = bos.toByteArray();
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

	/**
	 * 给图片添加水印、可设置水印图片旋转角度
	 * 
	 * @param srcImgPath
	 *            源图片路径
	 */
	private String getGODOGamesWaterMarker(String url) {
		String result = "";
		OutputStream os = null;
		String waterPic = "http://img-cdn.bigtiyu.com/wsc/sport/27501/s-219-171/ab09b3ef8ebf47c286cf495a66066ad6.png";
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
			// 根据1080原图等比压缩水印图大小及边距
			double prop = Double.valueOf(srcImg.getWidth(null)) / Double.valueOf(1080);
			waterPic = ImageHelper.upImageThumbnail(waterPic, (int) (prop * 219));
			// 得到水印Image对象。
			Image img = ImageIO.read(WebClientSupport.create().upEntity(waterPic).getContent());
			float alpha = 1.0f; // 透明度
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 表示水印图片的位置
			int width = (int) (prop * 229);
			int high = (int) (prop * 171);
			g.drawImage(img, srcImg.getWidth(null) - width, srcImg.getHeight(null) - high - 10, null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
			g.dispose();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ImageIO.write(buffImg, StringUtils.substringAfterLast(url, ".").toUpperCase(), bos);
			byte b[] = bos.toByteArray();
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

	/**
	 * 
	 * @param imgUrl
	 *            图片地址
	 * @return
	 */
	public String getBufferedImage(String imgUrl) {
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
