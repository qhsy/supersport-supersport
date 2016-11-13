package com.uhutu.dcom.component.z.util;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

/**
 * 图片处理工具类
 * @author 逄小帅
 *
 */
public class ImageUtil {
	
	
	
	
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
	
}
