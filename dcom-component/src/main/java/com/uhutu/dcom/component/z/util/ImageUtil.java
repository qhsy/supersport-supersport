package com.uhutu.dcom.component.z.util;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

import com.uhutu.zoocom.helper.ComHelper;
import com.uhutu.zooweb.io.ImageThumb;

/**
 * 图片处理工具类
 * @author 逄小帅
 *
 */
public class ImageUtil {
	
	private final static String addPath = "_g_t1_w{0}_h{1}.{2}";
	
	
	public static void drawStrCf(String content,Graphics2D g,int fontStyle,int fontSize,int x,int y){
		
		if(StringUtils.isNotEmpty(content)){
			
			AttributedString ats = new AttributedString(content);
			
		    Font f = new Font("Serif",fontStyle, fontSize);

		    ats.addAttribute(TextAttribute.FONT, f, 0,content.length() );
		    
		    AttributedCharacterIterator iter = ats.getIterator();
		    
		    g.drawString(iter, x, y);
			
		}
		
		
		
	}
	
	/**
	 * 合成图片
	 * @param abPath
	 * 		相对路径
	 * @param g
	 * 		画笔
	 * @param alpha
	 * 		透明度
	 */
	public static void drawImageCf(String abPath,Graphics2D g,float alpha,int x,int y,int width,int height){
		
		String realPath = "/hole/crossfit";
		
		URL url = ImageUtil.class.getResource(realPath+abPath);
		
		ImageIcon imageIcon2 = new ImageIcon(url);
		
		// 得到Image对象。
		Image img2 = imageIcon2.getImage();
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		// 表示水印图片的位置
		g.drawImage(img2, x, y, width, height, null);
		
	}
	
	/**
	 * 合成头像图片
	 * @param abPath
	 * 		相对路径
	 * @param g
	 * 		画笔
	 * @param alpha
	 * 		透明度
	 */
	public static void drawImageHead(String headUrl,Graphics2D g,float alpha,int x,int y,int width,int height){
		
		ImageIcon imageIcon2 = null;
		
		if(StringUtils.isNotEmpty(headUrl)){
			
			byte[] imageData = getImageData(headUrl);
			
			imageIcon2 = new ImageIcon(imageData);
			
		}else{
			
			String realPath = "/hole/crossfit/person/head.jpeg";
			
			URL url = ImageUtil.class.getResource(realPath);
			
			imageIcon2 = new ImageIcon(url);
			
		}
		
		
		// 得到Image对象。
		Image img2 = imageIcon2.getImage();
		
		g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		// 表示水印图片的位置
		g.drawImage(img2, x, y, width, height, null);
		
	}
	
	/**
	 * 获取头像数据
	 * @param imageUrl
	 * @return
	 */
	public static byte[] getImageData(String imageUrl){
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		
		try {
			
			HttpResponse response = WebClientComponent.doResponse(imageUrl);

			HttpEntity resEntity = response.getEntity();

			byte[] bytes = new byte[1024];

			int count = 0;

			while ((count = resEntity.getContent().read(bytes)) != -1) {
				bos.write(bytes, 0, count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bos.toByteArray();

		
	}
	
	/**
	 * 获取缩略图并同时返回缩略图的宽高 注意此方法只是根据固定规则处理原始图片的宽高 不需要将压缩后的图片路径存入数据库
	 * 
	 * @param sSource
	 * @param iHeight
	 * @return
	 */
	public static ImageThumb upThumbWithHeight(String sSource, int iHeight) {

		ImageThumb imageThumb = new ImageThumb();

		if (iHeight <= 0) {
			iHeight = 364;
		}

		String[] sSplit = sSource.split("/");

		for (int i = 0, j = sSplit.length; i < j; i++) {
			if (sSplit[i].indexOf(".") > 0) {
				sSplit[i] = sSplit[i] + "/gm";
				break;
			}
		}

		// 拿到后缀名
		String sFix = StringUtils.substringAfterLast(sSource, ".");

		int iWidth = 364;

		int iSourceWidth = 0;
		int iSourceHeight = 0;

		if (sSource.contains("/s-")) {

			Pattern p = Pattern.compile("/s-(\\d+)-(\\d+)/");
			Matcher m = p.matcher(sSource);

			if (m.find()) {

				iSourceWidth = Integer.valueOf(m.group(1));
				iSourceHeight = Integer.valueOf(m.group(2));

				iWidth = (int) Math.rint(Double.valueOf(iHeight) / Double.valueOf(iSourceHeight) * iSourceWidth);
				// 拼接新文件路径
				String sReturn = StringUtils.join(sSplit, "/")
						+ ComHelper.formatString(addPath, String.valueOf(iWidth),String.valueOf(iHeight), sFix);
				imageThumb.setThumbUrl(sReturn);
			}

		}

		imageThumb.setSourceUrl(sSource);

		// 判断如果是空 则认为是不是系统能压缩的图片 将压缩后的图片设置为源图片
		if (StringUtils.isBlank(imageThumb.getThumbUrl())) {
			imageThumb.setThumbUrl(imageThumb.getSourceUrl());
		}

		imageThumb.setSourceHeight(iSourceHeight);
		imageThumb.setSourceWidth(iSourceWidth);

		imageThumb.setThumbHeight(iHeight);
		imageThumb.setThumbWidth(iWidth);

		return imageThumb;

	}
	
	public static int calx(int width){
		
		int x = 750 - width;
		
		x = (int) Math.rint(x/2);
		
		if(x<0){
			
			x = 0;
			
		}
		
		return x;
		
	}
	
	public static int fontWidth(String str,int fontStyle,int fontSize){
		
		int width = 0;
		
		if(StringUtils.isNotEmpty(str)){
			
			Font f = new Font("Serif",fontStyle, fontSize);
			
			Rectangle2D rect = f.getStringBounds(str, new FontRenderContext(AffineTransform.getScaleInstance(1, 1), false, false));
			
			width =(int) Math.rint(rect.getWidth());
			
		}
		
		return width;
		
	}
	
	
}
