package com.uhutu.dcom.component.z.util;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.TextAttribute;
import java.net.URL;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

import javax.swing.ImageIcon;

import org.apache.commons.lang3.StringUtils;

/**
 * 图片处理工具类
 * @author 逄小帅
 *
 */
public class ImageUtil {
	
	
	
	
	public static void drawStrCf(String content,Graphics2D g,int fontStyle,int fontSize,int x,int y){
		
		content = StringUtils.defaultIfEmpty(content, "");
		
		AttributedString ats = new AttributedString(content);
		
	    Font f = new Font("微软雅黑",fontStyle, fontSize);

	    ats.addAttribute(TextAttribute.FONT, f, 0,content.length() );
	    
	    AttributedCharacterIterator iter = ats.getIterator();
	    
	    g.drawString(iter, x, y);
		
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
	
}
